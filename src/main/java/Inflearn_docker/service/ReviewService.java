package Inflearn_docker.service;

import Inflearn_docker.Repository.RestaurantRepository;
import Inflearn_docker.Repository.ReviewRepository;
import Inflearn_docker.model.ReviewEntity;
import Inflearn_docker.response.ReviewResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
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

    public ReviewResponse getRestaurantReview(Long restaurantId, Pageable page){

        // ReviewRepository 는 CustomReviewRepository 를 상속 중이기에, 아래 함수 사용이 가능
        Double avgScore = reviewRepository.getAvgScoreByRestaurantId(restaurantId);
        Slice<ReviewEntity> reviews = reviewRepository.findSliceByRestaurantId(restaurantId, page);

        return ReviewResponse.builder()
                .reviews(reviews.getContent())
                .page(
                        ReviewResponse.ReviewDtoPage.builder()
                                .offset(page.getPageNumber()*page.getPageSize())
                                .limit(page.getPageSize())
                                .build()
                )
                .build();
    }
}
