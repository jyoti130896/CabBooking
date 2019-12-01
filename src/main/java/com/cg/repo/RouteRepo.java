package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.dto.Route;

public interface RouteRepo extends JpaRepository<Route,Double>{
	@Query("SELECT r.distance FROM Route r where r.source=:source and r.destination=:destination")
	public Object getDistanceBySourceAndDestination(@Param("source")String source,@Param("destination")String destination);
}
