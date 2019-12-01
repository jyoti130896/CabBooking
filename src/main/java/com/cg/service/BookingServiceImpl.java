package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.Booking;
import com.cg.repo.BookingRepo;
@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingRepo repo;
	
//	@Autowired
//	private BookingDetailRepo repo1;
	
	@Override
	public Booking doBooking(Booking booking) {
		return repo.save(booking);
			
	}

	@Override
	public Booking fetchBookingById(int bookingId) {
		return repo.findById(bookingId).get();
	}

	@Override
	public List<Booking> fetchAllBooking() {
		return repo.findAll();
	}

	@Override
	public List<Booking> fetchBookingByUserId(int id) {
		return repo.fetchBookingByUserId(id);
	}

//	@Override
//	public List<BookingDetail> fetchUserDetailsByBookingId(int id) {
//		return repo1.fetchUserDetailsByBookingId(repo.findById(id).get());
//	}

}
