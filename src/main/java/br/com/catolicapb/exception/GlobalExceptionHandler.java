package br.com.catolicapb.exception;

import br.com.catolicapb.dto.ErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AlreadyPetToCustomerException.class)
    public ResponseEntity<ErrorResponseDTO> handleExistsPetToCustomer
            (AlreadyPetToCustomerException ex, WebRequest req) {
        var errorResponseDTO = ErrorResponseDTO.builder()
                .apiPath(req.getDescription(false))
                .errorMessage(ex.getMessage())
                .errorStatusCode(HttpStatus.BAD_REQUEST.value())
                .localDateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var validationErrorsMap = new HashMap<>();
        var errors = ex.getBindingResult().getAllErrors();

        errors.forEach( e -> {
            var fieldError = ((FieldError)e).getField();
            var valueError = e.getDefaultMessage();
            validationErrorsMap.put(fieldError, valueError);
        });

        return new ResponseEntity<>(validationErrorsMap, HttpStatus.BAD_REQUEST);
    }
}
