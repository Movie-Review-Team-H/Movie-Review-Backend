package partners.partners.domain.review.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import partners.partners.domain.review.entity.Review;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private Long movieId;
    private String reviewerName;
    private String content;
    private Double averageRating;
    private LocalDateTime createdAt;

    // 엔티티를 ReviewResponse로 변환하는 정적 메소드
    public static ReviewResponse fromEntity(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .movieId(review.getMovie().getId())
                .reviewerName(review.getReviewerName())
                .content(review.getContent())
                .averageRating(review.getAverageRating())
                .createdAt(review.getCreatedAt())
                .build();
    }
}