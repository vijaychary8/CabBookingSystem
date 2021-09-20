package com.example.cabservices.services;

import java.util.List;

import com.example.cabservices.entities.DriverEntity;

public interface DriverService {

	boolean addDriver(DriverEntity driver);

	boolean driverLogin(String vehicleNumber, String password);

//	boolean addVehicle(VehicleEntity vehicle);
//
	List<DriverEntity> getAllVehicles();

	List<DriverEntity> getPriceDetails(String vehicleNumber);

}
