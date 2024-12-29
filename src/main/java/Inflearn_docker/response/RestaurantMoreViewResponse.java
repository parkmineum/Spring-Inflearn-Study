package Inflearn_docker.response;

import Inflearn_docker.common.BaseEntity;
import Inflearn_docker.model.MenuEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class RestaurantMoreViewResponse extends BaseEntity {
    private final Long id;
    private final String name;
    private final String address;
    private final List<Menu> menus;

    @Builder
    @AllArgsConstructor
    public static class Menu{
        private final Long id;
        private final String name;
        private final Number price;
    }
}
