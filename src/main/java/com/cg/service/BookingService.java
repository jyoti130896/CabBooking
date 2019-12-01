package com.cg.service;

import java.util.List;

import com.cg.dto.Booking;

public interface BookingService {
	Booking doBooking(Booking booking);
	 Booking fetchBookingById(int bookingId);
	 List<Booking> fetchAllBooking();
	 List<Booking> fetchBookingByUserId(int id);
	//List<BookingDetail> fetchUserDetailsByBookingId(int id);
}
