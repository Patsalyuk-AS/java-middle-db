package com.github.aspatsalyuk.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MiddleDBException extends RuntimeException{

    private final int statusCode;
    private final int errorCode;
    private final String errorDescription;

}
