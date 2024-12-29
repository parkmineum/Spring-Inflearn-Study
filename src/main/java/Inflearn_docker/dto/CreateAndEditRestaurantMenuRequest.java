package Inflearn_docker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateAndEditRestaurantMenuRequest {
    private final String name;
    private final Integer price;
}
