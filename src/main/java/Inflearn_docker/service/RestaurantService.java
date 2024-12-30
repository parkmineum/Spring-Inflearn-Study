package Inflearn_docker.service;

import Inflearn_docker.Repository.MenuRepository;
import Inflearn_docker.Repository.RestaurantRepository;
import Inflearn_docker.request.CreateAndEditRestaurantRequest;
import Inflearn_docker.model.MenuEntity;
import Inflearn_docker.model.RestaurantEntity;
import Inflearn_docker.response.RestaurantMoreViewResponse;
import Inflearn_docker.response.RestaurantViewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @Transactional(readOnly = true)      // 생략 가능
    public List<RestaurantViewResponse> getAllRestaurants() {
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();

        // Entity 를 Response 객체로 변환
        return restaurants.stream().map((restaurant) -> RestaurantViewResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .build()
        ).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RestaurantMoreViewResponse getRestaurantDetail(Long restaurantId) {
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        List<MenuEntity> menus  = menuRepository.findAllByRestaurantId(restaurantId);

        return RestaurantMoreViewResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .menus(
                        menus.stream().map((menu) -> RestaurantMoreViewResponse.Menu.builder()
                                .id(menu.getId())
                                .name(menu.getName())
                                .price(menu.getPrice())
                                .build())
                                .collect(Collectors.toList())
                )
                .build();
    }

    @Transactional
    public RestaurantEntity createRestaurant( CreateAndEditRestaurantRequest request){
        RestaurantEntity restaurant = RestaurantEntity.builder()    // Id 값은 넘겨줄 필요가 없기 때문
                .name(request.getName())
                .address(request.getAddress())
                .build();
        restaurantRepository.save(restaurant);

        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .build();
            menuRepository.save(menuEntity);
        });
        return restaurant;
    }

    @Transactional
    public void editRestaurant(Long restaurantId, CreateAndEditRestaurantRequest request){
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("찾으시는 레스토랑이 없습니다."));
        restaurant.changeNameAndAddress(request.getName(), request.getAddress());
        restaurantRepository.save(restaurant);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);
        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurantId)
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .build();
            menuRepository.save(menuEntity);
        });
    }

    @Transactional
    public void deleteRestaurant(Long restaurantId){
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("찾으시는 레스토랑이 없습니다."));
        restaurantRepository.delete(restaurant);

        // 맛집에 연결된 리뷰들도 삭제 해줘야
        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);
    }
}
