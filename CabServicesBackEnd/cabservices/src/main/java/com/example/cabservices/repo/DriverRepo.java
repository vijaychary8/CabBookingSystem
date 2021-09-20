package com.example.cabservices.repo;

import java.util.List;

import com.example.cabservices.entities.DriverEntity;

public interface DriverRepo {

	boolean driverLogin(String vehicleNumber, String password);

	boolean addDriver(DriverEntity driver);

//	boolean addVehicle(VehicleEntity vehicle);
//

	List<DriverEntity> getPriceDetails(String vehicleNumber);

	List<DriverEntity> getAllVehicle();

}
