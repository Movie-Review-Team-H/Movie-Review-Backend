package partners.partners.domain.movie.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import partners.partners.domain.movie.dto.request.AddMovieRequest;
import partners.partners.domain.movie.entity.Movie;
import partners.partners.domain.movie.repository.MovieRepository;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    @Transactional
    public void createMovie(AddMovieRequest addMovieRequest){
        Movie movie = addMovieRequest.toSaveMovie();
        movieRepository.save(movie);
    }
    @Transactional
    public void deleteMovie(Long id){
        try {
            movieRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Movie not found with id: " + id);
        }
    }

}
