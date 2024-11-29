package partners.partners.domain.movie.dto.request;

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
public class AddMovieRequest {
    private String title;
    private Genre genre;
    private LocalDate openDate;
    private LocalDate closeDate;
    private Boolean isCurrentlyShowing;

    public Movie toSaveMovie(){
        return Movie.builder()
                .title(title)
                .genre(genre)
                .openDate(openDate)
                .closeDate(closeDate)
                .isCurrentlyShowing(isCurrentlyShowing)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isDeleted(false)
                .build();
    }
}