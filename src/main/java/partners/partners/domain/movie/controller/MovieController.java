package partners.partners.domain.movie.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partners.partners.common.CustomApiResponse;
import partners.partners.domain.movie.dto.request.AddMovieRequest;

import partners.partners.domain.movie.dto.request.FixMovieRequest;
import partners.partners.domain.movie.dto.response.MovieResponse;
import partners.partners.domain.movie.service.MovieService;


@Tag(name = "Movie", description = "영화 관련 API")
@RequestMapping("/movie")
@RestController
@AllArgsConstructor
@Slf4j

public class MovieController {
    private final MovieService movieService;

    @Operation(summary = "영화 등록",description = " 영화 등록하기")
    @PostMapping()
    public ResponseEntity<CustomApiResponse<String>> addMovie(@RequestBody AddMovieRequest addMovieRequest) {
        movieService.createMovie(addMovieRequest);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess("영화 등록됌"));
    }
    @Operation(summary = "영화 삭제",description = " 영화 소프트딜리트하기")
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomApiResponse<String>> deleteMovie(@PathVariable Long id) {
        movieService.soft_deleteMovie(id);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess("영화 삭제됌"));
    }
    @Operation(summary = "영화 수정",description = " 영화 수정하기")
    @PutMapping("/{id}")
    public ResponseEntity<CustomApiResponse<String>> fixMovie(@PathVariable Long id, @RequestBody FixMovieRequest fixMovieRequest) {
        movieService.updateMovie(id,fixMovieRequest);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess("영화 수정함"));
    }

    @Operation(summary = "영화 단일 조회", description = "영화 ID로 영화 조회하기")
    @GetMapping("/{id}")
    public ResponseEntity<CustomApiResponse<MovieResponse>> getMovie(@PathVariable Long id) {
        MovieResponse movieResponse = movieService.getMovieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess(movieResponse));
    }
}
