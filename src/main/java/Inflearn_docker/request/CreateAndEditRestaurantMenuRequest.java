package Inflearn_docker.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateAndEditRestaurantMenuRequest {
    private final String name;
    private final Integer price;
}
