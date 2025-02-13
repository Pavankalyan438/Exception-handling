package com.example.Exception_Training.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class ErrorResponse {

    private int statusCode;
    private String message;

    
}