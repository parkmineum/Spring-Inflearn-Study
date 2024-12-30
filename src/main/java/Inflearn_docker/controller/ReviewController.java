package Inflearn_docker.controller;

import Inflearn_docker.request.CreateReviewRequest;
import Inflearn_docker.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createReview(@RequestBody CreateReviewRequest request){
        reviewService.createReview(request.getRestaurantId(), request.getContent(), request.getScore());
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Long reviewId ){
        reviewService.deleteReview(reviewId);
    }
}
