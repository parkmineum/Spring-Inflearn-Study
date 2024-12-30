package Inflearn_docker.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
public class CreateReviewRequest {
    private final Long restaurantId;
    private final String content;
    private final Double score;
}
