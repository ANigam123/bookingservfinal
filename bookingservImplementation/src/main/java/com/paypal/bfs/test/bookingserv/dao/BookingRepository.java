package com.paypal.bfs.test.bookingserv.dao;


import java.util.List;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.BookingException;  

public interface BookingRepository {

    Booking save(Booking booking) throws BookingException;

    List<Booking> get() throws BookingException;
 
}
