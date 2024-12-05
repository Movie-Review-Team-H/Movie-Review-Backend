package partners.partners.domain.review.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partners.partners.common.CustomApiResponse;
import partners.partners.domain.review.dto.request.ReviewAddRequest;
import partners.partners.domain.review.dto.response.ReviewResponse;
import partners.partners.domain.review.service.ReviewService;

import java.util.List;

@Tag(name = "Review", description = "리뷰 관련 API")
@RequestMapping("/review")
@RestController
@AllArgsConstructor
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;
    @Operation(summary = "리뷰 목록 조회", description = "영화별 리뷰 목록 조회하기")
    @GetMapping("/list")
    public ResponseEntity<CustomApiResponse<List<ReviewResponse>>> getReviewList(
            @RequestParam Long movieId,
            @RequestParam(required = false) Double minAverageRating) {
        List<ReviewResponse> reviews = reviewService.getReviewsByMovieId(movieId, minAverageRating);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess(reviews));
    }
    @Operation(summary = "리뷰 달기",description = " 리뷰 둥록하기")
    @PostMapping({"/{movieId}"})
    public ResponseEntity<CustomApiResponse<String>> addReview(@PathVariable Long movieId, @RequestBody ReviewAddRequest reviewAddRequest) {

        reviewService.createReview(movieId,reviewAddRequest);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess("영화 등록됌"));
    }
}
