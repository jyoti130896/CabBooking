package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.dto.Booking;


public interface BookingRepo extends JpaRepository<Booking, Integer>{
	@Query("SELECT b FROM Booking b where b.userId=:id")
	List<Booking> fetchBookingByUserId(int id);

}
