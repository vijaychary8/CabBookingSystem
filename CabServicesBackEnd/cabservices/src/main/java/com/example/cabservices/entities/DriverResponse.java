package com.example.cabservices.entities;

import java.util.List;

public class DriverResponse {

	private boolean isError;
	private String message;
	private DriverEntity driver;
	private List<DriverEntity> driverList;

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DriverEntity getDriver() {
		return driver;
	}

	public void setDriver(DriverEntity driver) {
		this.driver = driver;
	}

	public List<DriverEntity> getDriverList() {
		return driverList;
	}

	public void setDriverList(List<DriverEntity> driverList) {
		this.driverList = driverList;
	}

}
