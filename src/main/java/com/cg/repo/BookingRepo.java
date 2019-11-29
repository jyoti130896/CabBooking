package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dto.Booking;


public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
