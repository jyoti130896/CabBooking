package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.dto.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
	@Query("SELECT v FROM Vehicle v WHERE v.vehicleName=:name")
	List<Vehicle> fetchAllVehicleByName(String name);
	@Query("SELECT v FROM Vehicle v WHERE v.vehicleType=:type")
	List<Vehicle> fetchAllVehicleByType(String type);
	@Query("SELECT v FROM Vehicle v WHERE v.seatingCapacity=:capacity")
	List<Vehicle> fetchAllVehicleBySeatingCapacity(int capacity);
}
