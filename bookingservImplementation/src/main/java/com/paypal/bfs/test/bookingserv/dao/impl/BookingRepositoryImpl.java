package com.paypal.bfs.test.bookingserv.dao.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingRepository;
import com.paypal.bfs.test.bookingserv.exception.BookingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepositoryImpl implements BookingRepository {

    static final String INSERT_QUERY = "insert into BOOKING (first_name, last_name, date_of_birth, checkin_datetime, checkout_datetime, total_price, deposit,line1, line2, city, city_state, zipcode) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    static final String UPDATE_QUERY = "update BOOKING set first_name = ? , last_name = ? ,date_of_birth = ?, checkin_datetime = ?, checkout_datetime = ?, total_price =? , deposit =?, line1 = ?, line2 = ?, city = ?, city_state = ?, zipcode = ? where id = ?";
    static final String SELECT_QUERY = "select * from BOOKING";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Booking save(Booking booking) throws BookingException {
        try {
            if (booking.getId() == null) {
                KeyHolder keyHolder = new GeneratedKeyHolder();
                jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection
                            .prepareStatement(INSERT_QUERY, new String[] { "id" });
                    ps.setString(1, booking.getFirstName());
                    ps.setString(2, booking.getLastName());
                    ps.setDate(3, new java.sql.Date(booking.getDateOfBirth().getTime()));
                    ps.setTimestamp(4, new java.sql.Timestamp(booking.getCheckinDatetime().getTime()));
                    ps.setTimestamp(5, new java.sql.Timestamp(booking.getCheckoutDatetime().getTime()));
                    ps.setBigDecimal(6, booking.getTotalPrice());
                    ps.setBigDecimal(7, booking.getDeposit());
                    ps.setString(8, booking.getAddress().getLine1());
                    ps.setString(9, booking.getAddress().getLine2());
                    ps.setString(10, booking.getAddress().getCity());
                    ps.setString(11, booking.getAddress().getState());
                    ps.setInt(12, booking.getAddress().getZipCode());
                    return ps;
                }, keyHolder);
                booking.setId(keyHolder.getKey().intValue());
            } else {
                int i = jdbcTemplate.update(UPDATE_QUERY, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, booking.getFirstName());
                        ps.setString(2, booking.getLastName());
                        ps.setDate(3, new java.sql.Date(booking.getDateOfBirth().getTime()));
                        ps.setTimestamp(4, new java.sql.Timestamp(booking.getCheckinDatetime().getTime()));
                        ps.setTimestamp(5, new java.sql.Timestamp(booking.getCheckoutDatetime().getTime()));
                        ps.setBigDecimal(6, booking.getTotalPrice());
                        ps.setBigDecimal(7, booking.getDeposit());
                        ps.setString(8, booking.getAddress().getLine1());
                        ps.setString(9, booking.getAddress().getLine2());
                        ps.setString(10, booking.getAddress().getCity());
                        ps.setString(11, booking.getAddress().getState());
                        ps.setInt(12, booking.getAddress().getZipCode());
                        ps.setInt(13, booking.getId());
                    }
                });
                if (i == 0)
                    throw new BookingException("400", "Bad Request. Invalid request json.",
                            "Unable to update data. ID: " + booking.getId() + " does not exist.");
            }
            return booking;
        } catch (BookingException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new BookingException("500", "Unable to process request. Internal Server Error.", ex.getMessage());
        }
    }

    @Override
    public List<Booking> get() throws BookingException {
        try {
            List<Map<String, Object>> res = jdbcTemplate.queryForList(SELECT_QUERY);
            System.out.println(res);
            List<Booking> bookingList = new ArrayList<>();

            for (Map<String, Object> bookingMap : res) {
                Booking booking = new Booking();
                Address address = new Address();
                booking.setId((int) bookingMap.get("ID"));
                booking.setFirstName((String) bookingMap.get("FIRST_NAME"));
                booking.setLastName((String) bookingMap.get("LAST_NAME"));
                booking.setDateOfBirth((java.sql.Date) bookingMap.get("DATE_OF_BIRTH"));
                booking.setCheckinDatetime((java.sql.Timestamp) bookingMap.get("CHECKIN_DATETIME"));
                booking.setCheckoutDatetime((java.sql.Timestamp) bookingMap.get("CHECKOUT_DATETIME"));
                booking.setTotalPrice((BigDecimal) bookingMap.get("TOTAL_PRICE"));
                booking.setDeposit((BigDecimal) bookingMap.get("DEPOSIT"));
                booking.setAddress(address);
                address.setLine1((String) bookingMap.get("LINE1"));
                address.setLine2((String) bookingMap.get("LINE2"));
                address.setCity((String) bookingMap.get("CITY"));
                address.setState((String) bookingMap.get("CITY_STATE"));
                address.setZipCode((int) bookingMap.get("ZIPCODE"));
                bookingList.add(booking);
            }
            return bookingList;
        } catch (Exception ex) {
            throw new BookingException("500", "Unable to process request. Internal Server Error.", ex.getMessage());
        }
    }

}
