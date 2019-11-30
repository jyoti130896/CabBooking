package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Exception.RouteNotFoundException;
import com.cg.Exception.UserNotFoundException;
import com.cg.Exception.UserNotSavedException;
import com.cg.Exception.VehicleDetailsNotFoundException;
import com.cg.Exception.WrongPasswordException;
import com.cg.dto.Booking;
import com.cg.dto.BookingDetail;
import com.cg.dto.Route;
import com.cg.dto.User;
import com.cg.dto.Vehicle;
import com.cg.service.BookingService;
import com.cg.service.RouteService;
import com.cg.service.UserService;
import com.cg.service.VehicleService;

@RestController
@RequestMapping(value = "/cab")
public class CabBookingController {
	
	@Autowired
	private VehicleService vservice;
	
	@PostMapping(value = "addVehicle", consumes = "application/json", produces = "application/json")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return vservice.addVehicle(vehicle);
	}
	
	@GetMapping(value = "/vehicle/{id}", produces = "application/json")
	public Vehicle fetchVehicleById(@PathVariable int id) throws VehicleDetailsNotFoundException {
		return vservice.fetchVehicleById(id);
	}
	
	@GetMapping(value = "vehicle/fetchAllVehicle", produces = "application/json")
	public List<Vehicle> fetchAllVehicle() {
		return vservice.fetchAllVehicle();
	}
	
	@GetMapping(value = "vehicle/{type}", produces = "application/json")
	public List<Vehicle> fetchVehicleByType(@PathVariable String type) throws VehicleDetailsNotFoundException {
		return vservice.fetchVehicleByType(type);
	}
	
	@GetMapping(value = "vehicle/{name}", produces = "application/json")
	public List<Vehicle> fetchVehicleByName(@PathVariable String name) throws VehicleDetailsNotFoundException {
		return vservice.fetchVehicleByName(name);
	}
	
	@GetMapping(value = "vehicle/{seatingCapacity}", produces = "application/json")
	public List<Vehicle> fetchVehicleBySeatingCapacity(@PathVariable int seatingCapacity) throws VehicleDetailsNotFoundException {
		return vservice.fetchVehicleBySeatingCapacity(seatingCapacity);
	}
	
	/*  *******************************************************************************************************************************  */
	
	@Autowired
	private RouteService rservice;
	
	@GetMapping(value = "route/{id}", produces = "application/json")
	public Route fetchRouteById(@PathVariable int id) throws RouteNotFoundException {
		return rservice.fetchRouteById(id);
	}
	
	@GetMapping(value = "route/{source}/{destination}", produces = "application/json")
	public double fetchDistanceBySourceAndDestination(@PathVariable String source, String destination) throws RouteNotFoundException {
		return rservice.fetchDistanceBySourceAndDestination(source, destination);
	}
	
	@GetMapping(value = "route/fetchAllRoute", produces = "application/json")
	public List<Route> fetchAllRoute() {
		return rservice.fetchAllRoute();
	}
	
	/*  *******************************************************************************************************************************  */

	@Autowired
	private BookingService bservice;
	
	@PostMapping(value = "doBooking", consumes = "application/json", produces = "application/json")
	public int doBooking(@RequestBody Booking booking) {
		return bservice.doBooking(booking);
	}
	
	@GetMapping(value = "booking/{id}", produces = "application/json")
	public Booking fetchBookingById(@PathVariable int id) {
		return bservice.fetchBookingById(id);
	}
	
	@GetMapping(value = "booking/fetchAllBooking", produces = "application/json")
	public List<Booking> fetchAllBooking() {
		return bservice.fetchAllBooking();
	}
	
	@GetMapping(value = "bookingByUser/{userId}", produces = "application/json")
	public  List<Booking> fetchBookingByUserId(@PathVariable int userId){
		return bservice.fetchBookingByUserId(userId);
	}
	
	@GetMapping(value = "userByBooking/{bookingId}", produces = "application/json")
	public  List<BookingDetail> fetchUserDetailsByBookingId(@PathVariable int bookingId){
		return bservice.fetchUserDetailsByBookingId(bookingId);
	}
	
	/*  *******************************************************************************************************************************  */

	@Autowired
	private UserService uservice;
	
	@PostMapping(value = "/user/add")
	public User addEmployee(@RequestBody User user) throws UserNotSavedException {
		return uservice.signUp(user);
	}
	
	@GetMapping(value = "/user/{id}")
	public User getById(@PathVariable String id) throws UserNotFoundException {
		return uservice.getById(id);
	}
	
	@PutMapping(value = "/user/update")
	public User update(@RequestBody User user) {
		return uservice.update(user);
	}
	
	@GetMapping(value = "/user/login/{id}/{password}")
	public User login(@PathVariable String id, @PathVariable String password)
			throws UserNotFoundException, WrongPasswordException {
		return uservice.login(id, password);
	}
	
	@GetMapping(value = "user/{userRole}", produces = "application/json")
	public List<User> getByUserRole(@PathVariable String userRole) throws UserNotFoundException {
		return uservice.getByUserRole(userRole);
	}
	
	@GetMapping(value = "user/fetchAllUser", produces = "application/json")
	public List<User> fetchAllUser() throws UserNotFoundException {
		return uservice.getAll();
	}
}
