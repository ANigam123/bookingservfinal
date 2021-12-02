package com.paypal.bfs.test.bookingserv.exception;

public class BookingException extends Exception {

    private final String status;
    private final String error;
    private final String description;

    public BookingException(String status, String error, String description) {
        super(description);
        this.status = status;
        this.error = error;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

}
