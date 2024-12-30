package Inflearn_docker.service;

import Inflearn_docker.Repository.RestaurantRepository;
import Inflearn_docker.Repository.ReviewRepository;
import Inflearn_docker.model.ReviewEntity;
import org.springframework.transaction.annotation.Transactional;

public class ReviewService {
    private RestaurantRepository restaurantRepository;
    private ReviewRepository reviewRepository;

    @Transactional
    public void createReview(Long restaurantId, String content, Double score){
        restaurantRepository.findById(restaurantId).orElseThrow();    // 유효성 검증

        ReviewEntity review = ReviewEntity.builder()
                .restaurantId(restaurantId)
                .content(content)
                .score(score)
                .build();
        reviewRepository.save(review);
    }

    @Transactional
    public void deleteReview(Long reviewId ){
        ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();    // 유효성 검증

        reviewRepository.delete(review);
    }
}
