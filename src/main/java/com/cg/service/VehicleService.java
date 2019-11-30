package com.cg.service;

import java.util.List;

import com.cg.Exception.VehicleDetailsNotFoundException;
import com.cg.dto.Vehicle;

public interface VehicleService {
Vehicle addVehicle(Vehicle vehicle);
	
	Vehicle fetchVehicleById(int vehicleId) throws VehicleDetailsNotFoundException;
	
	List<Vehicle> fetchAllVehicle();
	
	boolean removeVehicle(int vehicleId) throws VehicleDetailsNotFoundException;
	
	Vehicle updateVehicle(Vehicle vehicle);
	
	List<Vehicle> fetchVehicleByName(String name) throws VehicleDetailsNotFoundException;
	
	List<Vehicle> fetchVehicleByType(String type) throws VehicleDetailsNotFoundException;
	
	List<Vehicle> fetchVehicleBySeatingCapacity(String seatingCapacity) throws VehicleDetailsNotFoundException;
	
}
