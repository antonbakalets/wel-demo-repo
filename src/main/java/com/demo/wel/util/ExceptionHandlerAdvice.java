package com.demo.wel.util;

import com.demo.wel.eligibility.contract.ErrorData;
import com.demo.wel.eligibility.contract.ErrorDetail;
import com.demo.wel.eligibility.contract.ErrorResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorDetail> details = ex.getBindingResult().getFieldErrors().stream()
                .map(ErrorDetail::new)
                .toList();

        ErrorData errorData = ErrorData.builder()
                .code(ErrorCode.VALIDATION_ERROR)
                .message(ex.getBody().getDetail())
                .details(details)
                .build();
        ErrorResponse errorResponse = new ErrorResponse(errorData);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorData errorData = ErrorData.builder()
                .code(ErrorCode.VALIDATION_ERROR)
                .message(ex.getLocalizedMessage())
                .build();

        ErrorResponse errorResponse = new ErrorResponse(errorData);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
