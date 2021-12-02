package com.paypal.bfs.test.bookingserv.handler;

import javax.validation.ConstraintViolationException;

import com.paypal.bfs.test.bookingserv.api.model.ErrorResponseModel;
import com.paypal.bfs.test.bookingserv.exception.BookingException;
import com.paypal.bfs.test.bookingserv.impl.BookingResourceImpl;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice(assignableTypes = BookingResourceImpl.class)
public class BookingExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseModel> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        ErrorResponseModel errorResponse = new ErrorResponseModel();
        errorResponse.setStatus("400");
        errorResponse.setError("Bad Request. Invalid request json.");
        errorResponse.setDescription(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseModel> handleMethodArguementNotValid(MethodArgumentNotValidException ex) {
        StringBuilder errorDescription = new StringBuilder();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errorDescription.append(fieldError.getField()).append(" ").append(fieldError.getDefaultMessage())
                    .append(",");
        }
        String desc = errorDescription.toString();

        ErrorResponseModel errorResponse = new ErrorResponseModel();
        errorResponse.setStatus("400");
        errorResponse.setError("Bad Request. Invalid request json.");
        errorResponse.setDescription(desc.substring(0, desc.length() - 1));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseModel> handleConstraintViolationException(ConstraintViolationException ex) {
        ErrorResponseModel errorResponse = new ErrorResponseModel();
        errorResponse.setStatus("400");
        errorResponse.setError("Bad Request. Invalid request json.");
        errorResponse.setDescription("Request Json is null.");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookingException.class)
    public ResponseEntity<ErrorResponseModel> handleBookingException(BookingException ex) {
        ErrorResponseModel errorResponse = new ErrorResponseModel();
        errorResponse.setStatus(ex.getStatus());
        errorResponse.setError(ex.getError());
        errorResponse.setDescription(ex.getDescription());
        if ("500".equals(ex.getStatus()))
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
