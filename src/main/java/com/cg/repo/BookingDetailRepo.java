package com.cg.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.dto.Booking;
import com.cg.dto.BookingDetail;
public interface BookingDetailRepo extends JpaRepository<BookingDetail, Integer> {
	@Query("SELECT b FROM BookingDetail b WHERE b.booking=:booking")
	List<BookingDetail> fetchUserDetailsByBookingId(Booking booking);

}
