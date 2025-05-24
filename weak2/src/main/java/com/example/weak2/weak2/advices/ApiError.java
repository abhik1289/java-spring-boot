package com.example.weak2.weak2.advices;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;


@Builder
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> subError;
}
