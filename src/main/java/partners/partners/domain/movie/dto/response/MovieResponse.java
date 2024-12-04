package partners.partners.domain.movie.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import partners.partners.domain.movie.entity.Movie;
import partners.partners.domain.movie.enums.Genre;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private Long id;
    private String title;
    private Genre genre;
    private LocalDate openDate;
    private LocalDate closeDate;
    private boolean isCurrentlyShowing;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // fromEntity 메소드 추가
    public static MovieResponse fromEntity(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .openDate(movie.getOpenDate())
                .closeDate(movie.getCloseDate())
                .isCurrentlyShowing(movie.isCurrentlyShowing())
                .createdAt(movie.getCreatedAt())
                .updatedAt(movie.getUpdatedAt())
                .build();
    }
}
