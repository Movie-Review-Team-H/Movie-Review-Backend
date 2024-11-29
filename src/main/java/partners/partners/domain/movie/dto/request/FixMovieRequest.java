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
public class FixMovieRequest {
    private String title;
    private Genre genre;
    private LocalDate openDate;
    private LocalDate closeDate;
    private Boolean isCurrentlyShowing;


}
