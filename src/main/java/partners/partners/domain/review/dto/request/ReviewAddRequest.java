package partners.partners.domain.review.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import partners.partners.domain.movie.entity.Movie;
import partners.partners.domain.review.entity.Review;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewAddRequest {
    private String reviewerName;
    private String content;
    private Double averageRating;

    public Review toEntity(Movie movie) {
        return Review.builder()
                .reviewerName(reviewerName)
                .content(content)
                .averageRating(averageRating)
                .createdAt(LocalDateTime.now())
                .movie(movie)
                .build();
    }
}