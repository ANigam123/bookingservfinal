package com.paypal.bfs.test.bookingserv.service.impl;

import java.util.List;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingRepository;
import com.paypal.bfs.test.bookingserv.exception.BookingException;
import com.paypal.bfs.test.bookingserv.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repo;

    @Override
    public Booking save(Booking booking) throws BookingException {
        return repo.save(booking);
    }

    @Override
    public List<Booking> get() throws BookingException {
        return repo.get();
    }

}
