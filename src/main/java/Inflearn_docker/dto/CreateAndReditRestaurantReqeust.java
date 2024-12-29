package Inflearn_docker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateAndReditRestaurantReqeust{
    private final String name;
    private final String address;

    private final List<CreateAndReditRestaurantMenuReqeust> menus;

//    {
//        "id": Long,
//            "name": string,
//            "address": string,
//            "createdAt": string,
//            "updatedAt": string,
//            "menus": [
//        {"id": Long, "name": string, "price": int, "createdAt": string, "updatedAt": string},
//        {"id": Long, "name": string, "price": int, "createdAt": string, "updatedAt": string},
//    ...
//  ]
//    }
}
