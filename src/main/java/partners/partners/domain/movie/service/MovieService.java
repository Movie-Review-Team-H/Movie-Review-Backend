package partners.partners.domain.movie.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import partners.partners.domain.movie.dto.request.AddMovieRequest;
import partners.partners.domain.movie.dto.request.FixMovieRequest;
import partners.partners.domain.movie.dto.response.MovieResponse;
import partners.partners.domain.movie.entity.Movie;
import partners.partners.domain.movie.repository.MovieRepository;

import java.time.LocalDateTime;

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
    public void soft_deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("영화가 없습니다."));
        movieRepository.delete(movie);
    }
    @Transactional
    public void updateMovie(Long id, FixMovieRequest fixMovieRequest){
        Movie movie = movieRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("영화가 없습니다."));
        Movie updatedMovie = Movie.builder()
                .id(movie.getId()) // 기존 ID 유지
                .title(fixMovieRequest.getTitle()) // 제목 수정
                .genre(fixMovieRequest.getGenre()) // 장르 수정
                .openDate(fixMovieRequest.getOpenDate()) // 개봉일 수정
                .closeDate(fixMovieRequest.getCloseDate()) // 종영일 수정
                .isCurrentlyShowing(fixMovieRequest.getIsCurrentlyShowing()) // 상영중 여부 수정
                .createdAt(movie.getCreatedAt()) // 생성일자는 그대로 두기
                .updatedAt(LocalDateTime.now()) // 수정된 시간 기록
                .isDeleted(movie.getIsDeleted()) // 삭제 여부 그대로 유지
                .build();
        movieRepository.save(updatedMovie);
    }

    @Transactional
    public MovieResponse getMovieById(Long id) {
        Movie movie = movieRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("영화가 없습니다."));
        return MovieResponse.fromEntity(movie);
    }
}
