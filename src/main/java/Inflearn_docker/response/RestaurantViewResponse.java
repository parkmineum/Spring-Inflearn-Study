package Inflearn_docker.response;

import Inflearn_docker.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class RestaurantViewResponse extends BaseEntity {
    private Long id;
    private String name;
    private String address;

}
