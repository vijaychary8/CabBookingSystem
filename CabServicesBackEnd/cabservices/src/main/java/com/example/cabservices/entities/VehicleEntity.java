//package com.example.cabbookingsystem.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonRootName;
//
//@Entity
//@Table(name = "vehicle_table")
//@JsonRootName("vehicle_table")
//@JsonInclude(content = Include.NON_NULL)
//
//public class VehicleEntity implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 7257241153876440594L;
//	
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Id
//	@Column(name = "vehicleId")
//	@JsonProperty
//	private int vehicleId;
//
//	@Column(name = "vehicleType")
//	@JsonProperty
//	private String vehicleType;
// 
//	
//	@Column(name = "vehicleNumber" ,unique = true)
//	@JsonProperty
//	private String vehicleNumber;
//	
//	@Column(name = "capacity")
//	@JsonProperty
//	private int capacity;
//
//
//	@Column(name = "price")
//	@JsonProperty
//	private double price;
//	
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="vehicle")  //bidirectional 
//	private DriverEntity driver;
//
//
//	public int getCapacity() {
//		return capacity;
//	}
//
//	public void setCapacity(int capacity) {
//		this.capacity = capacity;
//	}
//
//	public int getVehicleId() {
//		return vehicleId;
//	}
//
//	public void setVehicleId(int vehicleId) {
//		this.vehicleId = vehicleId;
//	}
//
//	public String getVehicleType() {
//		return vehicleType;
//	}
//
//	public void setVehicleType(String vehicleType) {
//		this.vehicleType = vehicleType;
//	}
//
//	public String getVehicleNumber() {
//		return vehicleNumber;
//	}
//
//	public void setVehicleNumber(String vehicleNumber) {
//		this.vehicleNumber = vehicleNumber;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	
//	
//
//
//}
