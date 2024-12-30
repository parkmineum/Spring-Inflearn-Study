package Inflearn_docker.controller;

import Inflearn_docker.request.CreateAndEditRestaurantRequest;
import Inflearn_docker.model.RestaurantEntity;
import Inflearn_docker.response.RestaurantMoreViewResponse;
import Inflearn_docker.response.RestaurantViewResponse;
import Inflearn_docker.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantApiController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurant")   // 맛집 리스트 가져오기 API
    public List<RestaurantViewResponse> getRestaurants() {
        return List.of(RestaurantViewResponse.builder()
                .id(0L)
                .name("test name")
                .address("test address")
                .build());
    }

    @GetMapping("/restaurant/{restaurantId}")    // 맛집 정보 가져오기 API
    public List<RestaurantMoreViewResponse> getRestaurant(
            @PathVariable Long restaurantId
    ){
        return List.of(RestaurantMoreViewResponse.builder()
                .id(0L)
                .name("test name")
                .address("test address")
                .menus(List.of(RestaurantMoreViewResponse.Menu.builder()
                                .id(0L)
                                .name("test menu name")
                                .price(500)
                                .build()
                ))
                .build());
    }

    @PostMapping("/restaurant")    // 맛집 생성 API
    public RestaurantEntity createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
    ){
        return restaurantService.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")     // 맛집 수정 API
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ){
        restaurantService.editRestaurant(restaurantId, request);
    }

    @DeleteMapping("/restaurant/{restaurantId}")   // 맛집 삭제 API
    public void deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        restaurantService.deleteRestaurant(restaurantId);
    }
}
