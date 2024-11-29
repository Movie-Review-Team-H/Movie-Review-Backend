package partners.partners.domain.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import partners.partners.domain.movie.entity.Movie;

import java.awt.print.Book;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByIdAndIsDeletedFalse(Long id);
}
