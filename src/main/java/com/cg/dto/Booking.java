package com.cg.dto;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Bookings")
@SequenceGenerator(name = "bookingseq",sequenceName = "booking_seq", allocationSize = 1)
public class Booking {
	@Id
    @Column(name = "booking_id", length = 50)
	@GeneratedValue(generator = "bookingseq")
    private int bookingId;
	
	private int userId;
 
	@Column(name = "User_Name", length = 255)
    private String userName;
	
	@Column(name = "source", length = 255)
    private String source;
	
	@Column(name = "destination", length = 128)
	private String destination;
	
	
    @Column(name = "TotalAmount")
    private double totalAmount;
    
    @Column(name="paymentType")
    private String paymentType;
    
	@Temporal(TemporalType.DATE)
    @Column(name = "Date")
    private Date bookingDate;
    
    @Column(name = "Time")
    private LocalTime time = LocalTime.now();
    

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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


	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

    
}
