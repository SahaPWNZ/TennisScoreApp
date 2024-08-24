package com.sahapwnz.tennisscoreapp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponseDTO {
    private final String message;

    @Override
    public String toString() {
        return "errorMessage='" + message + '\'';
    }
}
