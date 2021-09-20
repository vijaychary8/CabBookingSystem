package com.example.cabservices.services;

import java.util.List;

import com.example.cabservices.entities.BookingEntity;
import com.example.cabservices.entities.UserEntity;

public interface UserService {

	boolean addUser(UserEntity user);

	boolean userLogin(String emailId, String password);

	boolean addBooking(BookingEntity booking);

	BookingEntity getBooking(int bookingId);

	List<BookingEntity> getAllBookings(String userName);

	boolean deleteBooking(int bookingId);

	void changeAvailability(String number);

	void changeTrueAvailability(String vehicleNumber);

	BookingEntity getAllDriverBookings(String vehicleNumber);

	UserEntity getUserDetails(String emailId);

}
