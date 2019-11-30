package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Exception.VehicleDetailsNotFoundException;
import com.cg.dto.Route;
import com.cg.dto.Vehicle;
import com.cg.repo.VehicleRepo;
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepo repo;

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return repo.save(vehicle);
	}

	@Override
	public Vehicle fetchVehicleById(int vehicleId) throws VehicleDetailsNotFoundException {
		try {
		return repo.findById(vehicleId).get();
		}
		catch (Exception e) {
			throw new VehicleDetailsNotFoundException("No vehicle details are available for vehicleId: " + vehicleId);
		}
	}

	@Override
	public List<Vehicle> fetchAllVehicle() {
		return repo.findAll();
	}

	@Override
	public boolean removeVehicle(int vehicleId) throws VehicleDetailsNotFoundException {
		try {
			repo.deleteById(vehicleId);
			return true;
		} catch (Exception e) {
			throw new VehicleDetailsNotFoundException("Invalid Vehicle Id provided: " + vehicleId);
		}
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return repo.save(vehicle);
	}

	@Override
	public List<Vehicle> fetchVehicleByName(String name) throws VehicleDetailsNotFoundException {
		if(repo.fetchAllVehicleByName(name).size()==0)
			throw new VehicleDetailsNotFoundException("No Vehicle found for this Name: " + name);
		return repo.fetchAllVehicleByName(name);
	}

	@Override
	public List<Vehicle> fetchVehicleByType(String type) throws VehicleDetailsNotFoundException {
		if(repo.fetchAllVehicleByType(type).size()==0)
			throw new VehicleDetailsNotFoundException("No Vehicle found for this type: " + type);
		return repo.fetchAllVehicleByType(type);
	}

	@Override
	public List<Vehicle> fetchVehicleBySeatingCapacity(String seatingCapacity) throws VehicleDetailsNotFoundException {
		if(repo.fetchAllVehicleBySeatingCapacity(seatingCapacity).size()==0)
			throw new VehicleDetailsNotFoundException("No Vehicle found for Seating Capaciy: " + seatingCapacity);
		return repo.fetchAllVehicleBySeatingCapacity(seatingCapacity);
	}

	@Override
	public Route addRoute(Route route) {
		return null;
	}

}
