package com.example.cabservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabservices.entities.DriverEntity;
import com.example.cabservices.repo.DriverRepo;
@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepo repo;
	
	
	@Override
	public boolean addDriver(DriverEntity driver) {
		return repo.addDriver(driver);
	}

	@Override
	public boolean driverLogin(String vehicleNumber, String password) {
		return repo.driverLogin(vehicleNumber,password);
	}

//	@Override
//	public boolean addVehicle(VehicleEntity vehicle) {
//		return repo.addVehicle(vehicle);
//	}
//
	@Override
	public List<DriverEntity> getAllVehicles() {
		return repo.getAllVehicle();
	}

	@Override
	public List<DriverEntity> getPriceDetails(String vehicleNumber) {
		return repo.getPriceDetails(vehicleNumber);
	}

}
