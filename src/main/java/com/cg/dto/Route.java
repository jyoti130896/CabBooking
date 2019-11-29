package com.cg.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "Route_Master")
@SequenceGenerator(name = "routeseq",sequenceName = "route_seq",allocationSize = 1)
public class Route {
	@Id
	 @Column(name = "route_id", length = 50, nullable = false)
    @GeneratedValue(generator = "routeseq")
	private String routeId;
	
    @Column(name = "source", nullable = false)
    private String source;
    
    @Column(name="destination")
    private String destination;
    
    @Column(name="distance")
    private String distance;
    
    @Column(name="duration")
    private double duration;
    
    
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
	@JoinTable(
			name = "vehicleandroute", 
			joinColumns = @JoinColumn(referencedColumnName = "route_id"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "vehicle_id"))
	Set<Vehicle> vehicles = new HashSet<Vehicle>();
    
    

	public Route(String routeId, String source, String destination, String distance, double duration,
			Set<Vehicle> vehicles) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
		this.vehicles = vehicles;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
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

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
    
}
