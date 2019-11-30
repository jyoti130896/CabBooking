package com.cg.service;

import java.util.List;

import com.cg.dto.Booking;
import com.cg.dto.BookingDetail;

public interface BookingService {
	int doBooking(Booking booking);
	 Booking fetchBookingById(int bookingId);
	 List<Booking> fetchAllBooking();
	 List<Booking> fetchOrderByUserId(int id);
	List<BookingDetail> fetchUserDetailsByBookingId(int id);
}
