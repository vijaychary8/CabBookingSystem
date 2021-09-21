package com.example.cabservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabservices.entities.DriverEntity;
import com.example.cabservices.entities.DriverResponse;
import com.example.cabservices.services.DriverService;

@RestController
@CrossOrigin("*")
public class DriverController {
	@Autowired
	private DriverService service;

	@PostMapping(path = "/adddriver")
	public DriverResponse addDriver(@RequestBody DriverEntity driver) {
		boolean isAdded = service.addDriver(driver);
		DriverResponse driverResponse = new DriverResponse();

		if (isAdded) {
			driverResponse.setError(false);
			driverResponse.setMessage("Added Sucessfully");
		} else {
			driverResponse.setError(true);
			driverResponse.setMessage("Record id not added");
		}
		return driverResponse;
	}

	@PostMapping(path = "/driverlogin/{vehicleNumber}/{password}")
	public DriverResponse driverLogin(@PathVariable String vehicleNumber, @PathVariable String password) {
		boolean isLogged = service.driverLogin(vehicleNumber, password);
		DriverResponse driverResponse = new DriverResponse();

		if (isLogged) {
			driverResponse.setError(false);
			driverResponse.setMessage("login successfully");
		} else {
			driverResponse.setError(true);
			driverResponse.setMessage("driver is not present");
		}
		return driverResponse;
	}
	@GetMapping(path = "/getallvehicles")

	public DriverResponse getAllVehicles() {
		List<DriverEntity>list = service.getAllVehicles();
		DriverResponse trainResponse = new DriverResponse();
		if (list != null) {
			trainResponse.setError(false);
			trainResponse.setMessage("All  record");
			trainResponse.setDriverList(list);
		} else {
			trainResponse.setError(true);
			trainResponse.setMessage(" record is not present");
			trainResponse.setDriverList(list);
		}
		return trainResponse;
	}

	@GetMapping(path = "/getpricedetails/{vehicleNumber}")

	public DriverResponse getPriceDetails(@PathVariable String vehicleNumber) {
		List<DriverEntity>list = service.getPriceDetails(vehicleNumber);
		DriverResponse trainResponse = new DriverResponse();
		if (list != null) {
			trainResponse.setError(false);
			trainResponse.setMessage("All  record");
			trainResponse.setDriverList(list);
		} else {
			trainResponse.setError(true);
			trainResponse.setMessage(" record is not present");
			trainResponse.setDriverList(list);
		}
		return trainResponse;
	}


}
