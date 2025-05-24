package com.example.weak2.weak2.advices;

import com.example.weak2.weak2.exceptions.ResourcesNotFoundExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
// import java.util.NoSuchElementException;

import java.util.stream.Collectors;

@SuppressWarnings("null")
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundExceptions.class)
    public ResponseEntity<ApiResponse<?>> resourcesNotFound(ResourcesNotFoundExceptions exception) {
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage()).build();

        return buildApiResponseEntity(apiError);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> otherException(Exception exception) {
        ApiError apiError = ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage()).build();

        return buildApiResponseEntity(apiError);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input")
                .subError(errors)
                .build();
        return buildApiResponseEntity(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildApiResponseEntity(ApiError apiError) {

        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());

    }
}
