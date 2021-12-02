package com.paypal.bfs.test.bookingserv.service;

import java.util.List;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.BookingException;

public interface BookingService {

    Booking save(Booking booking) throws BookingException;

    List<Booking> get() throws BookingException;
 
}
