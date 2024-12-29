package Inflearn_docker.controller;

import Inflearn_docker.dto.CreateAndReditRestaurantMenuReqeust;
import Inflearn_docker.dto.CreateAndReditRestaurantReqeust;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApiController {

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
    public String createRestaurant(
            @RequestBody CreateAndReditRestaurantReqeust request
    ){
        return "맛집 생성하기 , 맛집 이름 = " + request.getName() + "맛집 주소: " + request.getAddress()
                + "맛집 메뉴:" + request.getMenus().get(0).getName() + request.getMenus().get(0).getPrice();
    }

    @PutMapping("/restaurant/{restaurantId}")     // 맛집 수정 API
    public String editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndReditRestaurantMenuReqeust request
    ){
        return "맛집 수정하기" + restaurantId + request.getName() + request.getPrice();
    }

    @DeleteMapping("/restaurant/{restaurantId}")   // 맛집 삭제 API
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        return "" + restaurantId;
    }


}
