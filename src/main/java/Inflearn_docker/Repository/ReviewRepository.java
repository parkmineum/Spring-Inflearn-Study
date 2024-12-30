package Inflearn_docker.Repository;

import Inflearn_docker.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, CustomReviewRepository {
    // 상속을 통해 CRUD 기반의 기본 ReivewRepository는 좀 더 다양한 기능 제공이 가능 (CustomReviewRepository)
}
