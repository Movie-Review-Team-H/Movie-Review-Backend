package partners.partners.domain.review.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import partners.partners.domain.movie.entity.Movie;
import partners.partners.domain.movie.repository.MovieRepository;
import partners.partners.domain.review.dto.request.ReviewAddRequest;
import partners.partners.domain.review.dto.response.ReviewResponse;
import partners.partners.domain.review.entity.Review;
import partners.partners.domain.review.repository.ReviewRepository;
import partners.partners.exception.ReviewNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public List<ReviewResponse> getReviewsByMovieId(Long movieId, Double minAverageRating) {
        // 리뷰 목록을 등록일의 역순으로 가져옴
        List<Review> reviews = reviewRepository.findByMovieIdOrderByCreatedAtDesc(movieId);

        // 리뷰 목록이 비어있을 경우 예외 처리
        if (reviews.isEmpty()) {
            throw new ReviewNotFoundException("해당 영화에 대한 리뷰를 찾을 수 없습니다.");
        }

        // 평점 평균 조건이 있을 경우 필터링
        if (minAverageRating != null) {
            reviews = reviews.stream()
                    .filter(review -> review.getAverageRating() >= minAverageRating)
                    .collect(Collectors.toList());
        }

        // Review 엔티티를 ReviewResponse DTO로 변환하여 반환
        return reviews.stream()
                .map(ReviewResponse::fromEntity)
                .collect(Collectors.toList());
    }
    @Transactional
    public void createReview(Long movieId, ReviewAddRequest reviewAddRequest) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("영화를 찾을 수 없습니다."));
        Review review = reviewAddRequest.toEntity(movie);
        reviewRepository.save(review);
    }

}
