package com.cg.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.FetchType;

@Entity
@Table(name = "Booking_Details")
@SequenceGenerator(name = "detailseq",sequenceName = "detail_seq",allocationSize = 1)
public class BookingDetail {
	@Id
    @Column(name = "ID", length = 50, nullable = false)
    @GeneratedValue(generator = "detailseq")
    private int id;
    
    @Column(name="vehicleId")
    private int vehicleId;
    
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(referencedColumnName ="booking_id" )
    private Booking booking;
    
    @Column(name = "source", nullable = false)
    private String source;
    
    @Column(name="destination")
    private String destination;
    
    @Column(name="vehicleName")
    private String vehicleName;
    
    @Column(name="RideTotal")
    private double rideTotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public double getRideTotal() {
		return rideTotal;
	}

	public void setRideTotal(double rideTotal) {
		this.rideTotal = rideTotal;
	}
    
    
}
