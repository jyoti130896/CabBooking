package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dto.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

}
