package com.paypal.bfs.test.bookingserv.validator;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.BookingException;

import org.springframework.stereotype.Component;

@Component
public class CustomValidator {

    public void validateRequest(Booking booking) throws BookingException {
        if (booking.getTotalPrice().compareTo(booking.getDeposit()) < 0) {
            throw createException("400", "Bad Request. Invalid request json.", "Total price is less than deposit");
        }

        if (booking.getCheckinDatetime().compareTo(booking.getCheckoutDatetime()) > 0) {
            throw createException("400", "Bad Request. Invalid request json.",
                    "Checkin Date Time is greater than Checkout Date Time");
        }
    }

    private BookingException createException(String status, String error, String description) {
        BookingException ex = new BookingException(status, error, description);
        return ex;
    }

}
