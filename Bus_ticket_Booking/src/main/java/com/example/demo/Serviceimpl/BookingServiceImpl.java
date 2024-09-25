package com.example.demo.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Booking;
import com.example.demo.Repo.BookingRepo;
import com.example.demo.Service.BookingService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;
    
    @Override
    public Booking createBooking(Booking booking) {
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus("CONFIRMED");
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepo.findById(id);
    }

   

    @Override
    public void cancelBooking(Long id) {
        Optional<Booking> booking = bookingRepo.findById(id);
        booking.ifPresent(b -> {
            b.setStatus("CANCELLED");
            b.setCancellationTime(LocalDateTime.now());
            bookingRepo.save(b);
        });
    }
}

