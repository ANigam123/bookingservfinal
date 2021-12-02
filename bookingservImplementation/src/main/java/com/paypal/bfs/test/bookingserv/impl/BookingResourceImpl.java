package com.paypal.bfs.test.bookingserv.impl;

import java.util.List;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.BookingException;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import com.paypal.bfs.test.bookingserv.validator.CustomValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    private BookingService service;

    @Autowired
    private CustomValidator validator;

    @Override
    public String check() {
        return "Success";
    }

    @Override
    public ResponseEntity<Booking> create(Booking booking) throws BookingException {
        validator.validateRequest(booking);
        return new ResponseEntity<>(service.save(booking), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Booking>> get() throws BookingException {
        return new ResponseEntity<>(service.get(), HttpStatus.OK);
    }
}
