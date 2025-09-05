package evertonc15.com.github.pet_shop.exception;

import evertonc15.com.github.pet_shop.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleNotFound(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                        .message(ex.getMessage())
                        .statusHttp(HttpStatus.NOT_FOUND.value())
                        .build()
                );
    }

    public ResponseEntity<ResponseDTO> handleAlreadyExists(ProductAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseDTO.builder()
                        .message(ex.getMessage())
                        .statusHttp(HttpStatus.BAD_REQUEST.value())
                        .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Erro de validação");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseDTO.builder()
                        .message(errorMessage)
                        .statusHttp(HttpStatus.BAD_REQUEST.value())
                        .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDTO.builder()
                        .statusHttp(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message("Erro inesperado: " + ex.getMessage())
                        .build());
    }
}
