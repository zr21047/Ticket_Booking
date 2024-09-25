package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Booking;

public interface BookingService {
	
	List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long id);
    Booking createBooking(Booking booking);
    void cancelBooking(Long id);

}
