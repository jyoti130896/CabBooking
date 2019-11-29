package com.cg.repo;
import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.dto.BookingDetail;
public interface BookingDetailRepo extends JpaRepository<BookingDetail, Integer> {

}
