package partners.partners.domain.movie.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import partners.partners.domain.movie.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

import java.time.LocalDate;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE  movie SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private LocalDate openDate;

    @Column
    private LocalDate closeDate;



    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean isCurrentlyShowing;

    @Column(name = "deleted", nullable = false)
    private Boolean isDeleted = false;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)  // updatable = false로 설정하여 업데이트가 되지 않도록 함
    private LocalDateTime createdAt;



}
