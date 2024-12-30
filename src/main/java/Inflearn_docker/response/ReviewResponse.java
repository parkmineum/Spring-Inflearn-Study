package Inflearn_docker.response;

import Inflearn_docker.model.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ReviewResponse {

    private Double avgScore;
    private List<ReviewEntity> reviews;
    private ReviewDtoPage page;

    @Builder
    @Getter
    @AllArgsConstructor
    public static class ReviewDtoPage{
        private Integer offset;
        private Integer limit;
    }

//    {
//        "avgScore": float, // 평균 별점
//        "reviews": [
//        {"id": int, "content": string, "score": float, "createdAt": string},
//        {"id": int, "content": string, "score": float, "createdAt": string},
//        {"id": int, "content": string, "score": float, "createdAt": string}
//  ],
//        "page": {
//        "offset": int,
//        "limit": int
//    }
//    }
}
