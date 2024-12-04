package partners.partners.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import partners.partners.common.CustomApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    // MovieNotFoundException 처리
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<CustomApiResponse<String>> handleMovieNotFoundException(MovieNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(CustomApiResponse.onError(ex.getMessage()));
    }

    // ReviewNotFoundException 처리
    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<CustomApiResponse<String>> handleReviewNotFoundException(ReviewNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(CustomApiResponse.onError(ex.getMessage()));
    }
}
