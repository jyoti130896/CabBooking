package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.dto.Route;

public interface RouteRepo extends JpaRepository<Route, Integer>{
	@Query("SELECT r.distance FROM Route r where r.source=:source and r.destination=:destination")
	double getDistanceBySourceAndDestination(String source,String destination);
}
