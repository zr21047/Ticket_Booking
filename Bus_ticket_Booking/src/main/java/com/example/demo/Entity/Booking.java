package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private User user;

	@ManyToOne
	private Bus bus;

	private int seatNumber;

	private LocalDateTime bookingTime;
	private LocalDateTime cancellationTime;

	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public LocalDateTime getCancellationTime() {
		return cancellationTime;
	}

	public void setCancellationTime(LocalDateTime cancellationTime) {
		this.cancellationTime = cancellationTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Booking(Long id, User user, Bus bus, int seatNumber, LocalDateTime bookingTime,
			LocalDateTime cancellationTime, String status) {
		super();
		this.id = id;
		this.user = user;
		this.bus = bus;
		this.seatNumber = seatNumber;
		this.bookingTime = bookingTime;
		this.cancellationTime = cancellationTime;
		this.status = status;
	}

}
