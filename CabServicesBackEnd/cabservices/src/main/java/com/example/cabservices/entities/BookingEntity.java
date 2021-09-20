package com.example.cabservices.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "booking_table")
@JsonRootName("booking_table")
@JsonInclude(content = Include.NON_NULL)

public class BookingEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3484017742759930114L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "bookingId")
	@JsonProperty
	private int bookingId;

	@Column(name = "userName")
	@JsonProperty
	private String userName;

	@Column(name = "mobileNo")
	@JsonProperty
	private String mobileNo;

	@Column(name = "vehicleNumber", unique = true)
	@JsonProperty
	private String vehicleNumber;
	
	@Column(name = "driverName")
	@JsonProperty
	private String driverName;

	@Column(name = "source")
	@JsonProperty
	private String source;
	
	@Column(name = "destination")
	@JsonProperty
	private String destination;

	@Column(name = "fare")
	@JsonProperty
	private double fare;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
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

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
