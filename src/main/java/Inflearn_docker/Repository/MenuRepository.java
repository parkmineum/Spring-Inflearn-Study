package Inflearn_docker.Repository;

import Inflearn_docker.model.MenuEntity;
import Inflearn_docker.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    public List<MenuEntity> findAllByRestaurantId(Long restaurantId);
}
