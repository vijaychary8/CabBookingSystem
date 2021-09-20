package com.example.cabservices.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "driver_table")
@JsonRootName("driver_table")
@JsonInclude(content = Include.NON_NULL)

public class DriverEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 875628255319435825L;

	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "driverId")
	@JsonProperty
	private int driverId;

	@Column(name = "driverName")
	@JsonProperty
	private String driverName;

	
	@Column(name = "password")
	@JsonProperty
	private String password;


	@Column(name = "isAvailable")
	@JsonProperty
	private String isAvailable;
	
	@Column(name = "vehicleType")
	@JsonProperty
	private String vehicleType;
 
	
	@Column(name = "vehicleNumber" ,unique = true)
	@JsonProperty
	private String vehicleNumber;
	
	@Column(name = "capacity")
	@JsonProperty
	private int capacity;


	@Column(name = "price")
	@JsonProperty
	private double price;


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String isAvailable() {
		return isAvailable;
	}


	public void setAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


}
