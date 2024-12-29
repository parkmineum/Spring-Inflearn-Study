package Inflearn_docker.Repository;

import Inflearn_docker.model.MenuEntity;
import Inflearn_docker.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
