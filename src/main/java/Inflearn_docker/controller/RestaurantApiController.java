package Inflearn_docker.controller;

import Inflearn_docker.dto.CreateAndEditRestaurantMenuRequest;
import Inflearn_docker.dto.CreateAndEditRestaurantRequest;
import Inflearn_docker.model.RestaurantEntity;
import Inflearn_docker.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestaurantApiController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurant")   // 맛집 리스트 가져오기 API
    public String getRestaurants() {
        return "";
    }

    @GetMapping("/restaurant/{restaurantId}")    // 맛집 정보 가져오기 API
    public String getRestaurant(
            @PathVariable Long restaurantId
    ){
        return "맛집 정보 가져오기" + restaurantId;
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
