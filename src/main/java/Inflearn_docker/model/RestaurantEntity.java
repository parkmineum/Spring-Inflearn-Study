package Inflearn_docker.model;

import Inflearn_docker.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurant")
@Entity
public class RestaurantEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    public void changeNameAndAddress(String name, String address){
        this.name = name;
        this.address = address;
    }
}
