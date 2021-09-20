package com.example.cabservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabservices.entities.BookingEntity;
import com.example.cabservices.entities.BookingResponse;
import com.example.cabservices.entities.UserEntity;
import com.example.cabservices.entities.UserResponse;
import com.example.cabservices.services.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(path = "/adduser")
	public UserResponse addUser(@RequestBody UserEntity user) {
		boolean isAdded = service.addUser(user);
		UserResponse userResponse = new UserResponse();

		if (isAdded) {
			userResponse.setError(false);
			userResponse.setMessage("Registerd Sucessfully");
		} else {
			userResponse.setError(true);
			userResponse.setMessage("Record id not added");
		}
		return userResponse;
	}

	@PostMapping(path = "/userlogin/{emailId}/{password}")
	public UserResponse adminLogin(@PathVariable String emailId, @PathVariable String password) {
		boolean isLogged = service.userLogin(emailId, password);
		UserResponse userResponse = new UserResponse();

		if (isLogged) {
			userResponse.setError(false);
			userResponse.setMessage("login successfully");
		} else {
			userResponse.setError(true);
			userResponse.setMessage("user not added");
		}
		return userResponse;
	}

	@PostMapping(path = "/addBooking")
	public BookingResponse addBooking(@RequestBody BookingEntity booking) {
		boolean isAdded = service.addBooking(booking);
		BookingResponse bookingResponse = new BookingResponse();
		System.out.println(booking.getVehicleNumber());
		
		String number=booking.getVehicleNumber();
		if (isAdded) {
			service.changeAvailability(number);
			bookingResponse.setError(false);
			bookingResponse.setMessage("booked Sucessfully");
		} else {
			bookingResponse.setError(true);
			bookingResponse.setMessage("booked Unsucessfully");
		}
		return bookingResponse;
	}
	
	
	@GetMapping(path = "/getbooking/{bookingId}")
	public BookingResponse getBooking(@PathVariable int bookingId) {
		BookingEntity info = service.getBooking(bookingId);
		BookingResponse bookResponse = new BookingResponse();

		if (info != null) {
			bookResponse.setError(false);
			bookResponse.setMessage("Got the record");
			bookResponse.setBooking(info);
		} else {
			bookResponse.setError(true);
			bookResponse.setMessage("train id is not present");
			bookResponse.setBooking(info);
		}
		return bookResponse;
	}

	@GetMapping(path = "/getallbookings/{userName}")

	public BookingResponse getAllBookingss(@PathVariable String userName) {
		System.out.println(userName);
		List<BookingEntity>list = service.getAllBookings(userName);
		BookingResponse trainResponse = new BookingResponse();
		if (list != null) {
			trainResponse.setError(false);
			trainResponse.setMessage("All train record");
			trainResponse.setBookiList(list);
		} else {
			trainResponse.setError(true);
			trainResponse.setMessage(" record is not present");
			trainResponse.setBookiList(list);
		}
		return trainResponse;
	}

	@DeleteMapping(path = "/deletebooking/{bookingId}")
	public BookingResponse deleteBooking(@PathVariable int bookingId) {
		BookingResponse response=new BookingResponse();
		response =getBooking(bookingId);
		BookingEntity booking=new BookingEntity();
		booking=response.getBooking();
		System.out.println(booking.getVehicleNumber());
		String vehicleNumber=booking.getVehicleNumber();
		boolean isDeleted = service.deleteBooking(bookingId);
		BookingResponse bookingResponse = new BookingResponse();

		if (isDeleted) {
			service.changeTrueAvailability(vehicleNumber);
			bookingResponse.setError(false);
			bookingResponse.setMessage("booking  deleted successfully");
		} else {
			bookingResponse.setError(true);
			bookingResponse.setMessage("Record id not deleted");
		}
		return bookingResponse;
	}
	
	@GetMapping(path = "/getalldriverbookings/{vehicleNumber}")

	public BookingResponse getAllDriverBookings(@PathVariable String vehicleNumber) {
		System.out.println(vehicleNumber);
		BookingEntity booking = service.getAllDriverBookings(vehicleNumber);
		BookingResponse trainResponse = new BookingResponse();
		if (booking != null) {
			trainResponse.setError(false);
			trainResponse.setMessage("All train record");
			trainResponse.setBooking(booking);
		} else {
			trainResponse.setError(true);
			trainResponse.setMessage(" record is not present");
			trainResponse.setBooking(booking);
		}
		return trainResponse;
	}


	@GetMapping(path = "/getuserdetails/{emailId}")

	public UserResponse getUserDetails(@PathVariable String emailId) {
		UserEntity booking = service.getUserDetails(emailId);
		UserResponse trainResponse = new UserResponse();
		if (booking != null) {
			trainResponse.setError(false);
			trainResponse.setMessage("All train record");
			trainResponse.setUser(booking);
		} else {
			trainResponse.setError(true);
			trainResponse.setMessage(" record is not present");
			trainResponse.setUser(booking);
		}
		return trainResponse;
	}

}
