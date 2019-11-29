package com.cg.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Vehicle_Master")
public class Vehicle {
	@Id
	@Column(name = "Vehicle_Id", length = 20)
	@NotEmpty(message = "Vehicle id cannot be empty")
	private String vehicleId;

	@Column(name = "Vehicle_Type", length = 20)
	@NotEmpty(message = "Vehicle cannot be empty")
	@Size(max = 20, message = "max size of vehicle type is 20")
	private String vehicleType;

	@Column(name = "Vehicle_Name", length = 20)
	@NotEmpty(message = "Vehicle Name cannot be empty")
	@Size(max = 20, message = "max size of vehicle Name is 20")
	private String vehicleName;

	@Column(name = "Vehicle_Fair", length = 20)
	@NotEmpty(message = "Vehicle Fair cannot be empty")
	@Size(max = 20, message = "max size of vehicle fair is 20")
	private String vehicleFair;

	@Column(name = "Seating_Capacity", length = 20)
	@NotEmpty(message = "Seating Capacity cannot be empty")
	@Size(max = 20, message = "max size of seating capacity is 8")
	private String seatingCapacity;

	@ManyToMany(mappedBy = "vehicles", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, })
	Set<Route> routes = new HashSet<Route>();

	public Vehicle(String vehicleId, String vehicleType, String vehicleName, String vehicleFair, String seatingCapacity,
			Set<Route> routes) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.vehicleName = vehicleName;
		this.vehicleFair = vehicleFair;
		this.seatingCapacity = seatingCapacity;
		this.routes = routes;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleFair() {
		return vehicleFair;
	}

	public void setVehicleFair(String vehicleFair) {
		this.vehicleFair = vehicleFair;
	}

	public String getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(String seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

}
