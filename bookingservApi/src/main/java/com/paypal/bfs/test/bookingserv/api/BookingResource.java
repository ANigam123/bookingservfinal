package com.paypal.bfs.test.bookingserv.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.BookingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Validated
public interface BookingResource {

    @RequestMapping(value = "/v1/bfs/heathcheck", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    String check();

    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     * @throws BookingException
     */
    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.POST)
    ResponseEntity<Booking> create(@NotNull @Valid @RequestBody(required = false) Booking booking) throws BookingException;

    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.GET)
    ResponseEntity<List<Booking>> get() throws BookingException;
}
