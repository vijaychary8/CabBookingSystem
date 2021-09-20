package com.example.cabservices.repo;

import java.util.List;

import com.example.cabservices.entities.BookingEntity;
import com.example.cabservices.entities.UserEntity;

public interface UserRepo {

	boolean addUser(UserEntity user);

	boolean userLogin(String emailId, String password);

	boolean addBooking(BookingEntity booking);

	BookingEntity getbooking(int bookingId);

	List<BookingEntity> getAllBookings(String userName);

	boolean deleteBooking(int bookingId);

	void changeAvailability(String number);

	void changeYesAvailability(String vehicleNumber);

	BookingEntity getAllDriversBooking(String vehicleNumber);

	UserEntity getUserDetails(String emailId);

}
