package Inflearn_docker.controller;

import Inflearn_docker.request.CreateReviewRequest;
import Inflearn_docker.response.ReviewResponse;
import Inflearn_docker.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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

    // /restaurant/{restaurantId}/reviews?offset={offset}&limit={limit}
    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ReviewResponse getRestaurantReviews(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestParam("offset") Integer offset,
            @RequestParam("limit") Integer limit
    ){
       return reviewService.getRestaurantReview(restaurantId, PageRequest.of(offset/limit, limit));
    }
}
