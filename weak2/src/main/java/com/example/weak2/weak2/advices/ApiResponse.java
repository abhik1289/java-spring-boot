package com.example.weak2.weak2.advices;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Pattern;
import lombok.Data;



@Data
public class ApiResponse<T> {

    @Pattern(regexp = "hh-min-ss yyyy-MM-dd")
    // Assuming the pattern is for a timestamp, adjust as necessary
    private LocalDateTime timestamp;
    private T data;
    private ApiError error;

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }

}
