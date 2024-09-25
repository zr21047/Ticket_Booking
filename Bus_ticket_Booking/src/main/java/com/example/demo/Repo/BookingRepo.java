package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
