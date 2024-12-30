package Inflearn_docker.Repository;


import Inflearn_docker.model.ReviewEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomReviewRepository {

    Double getAvgScoreByRestaurantId(Long restaurantId);

    // 페이징 처리를 위한 Slice 사용
    Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable pageable);
}
