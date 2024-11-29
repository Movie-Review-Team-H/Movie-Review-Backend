package partners.partners.domain.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import partners.partners.domain.movie.entity.Movie;

import java.awt.print.Book;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
