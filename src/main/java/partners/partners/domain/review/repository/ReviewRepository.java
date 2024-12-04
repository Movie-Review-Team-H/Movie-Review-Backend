package partners.partners.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import partners.partners.domain.review.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 영화 ID로 리뷰 목록을 등록일의 역순으로 조회
    List<Review> findByMovieIdOrderByCreatedAtDesc(Long movieId);
}
