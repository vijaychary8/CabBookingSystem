package com.example.cabservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabservices.entities.BookingEntity;
import com.example.cabservices.entities.UserEntity;
import com.example.cabservices.repo.UserRepo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepo repo;

	@Override
	public boolean addUser(UserEntity user) {
		return repo.addUser(user);
	}

	@Override
	public boolean userLogin(String emailId, String password) {
		return repo.userLogin(emailId, password);
	}

	@Override
	public boolean addBooking(BookingEntity booking) {
		return repo.addBooking(booking);
	}

	@Override
	public BookingEntity getBooking(int bookingId) {
		return repo.getbooking(bookingId);
	}

	@Override
	public List<BookingEntity> getAllBookings(String userName) {
		return repo.getAllBookings(userName);
	}

	@Override
	public boolean deleteBooking(int bookingId) {
		return repo.deleteBooking(bookingId);
	}

	@Override
	public void changeAvailability(String number) {
		 repo.changeAvailability(number);

	}

	@Override
	public void changeTrueAvailability(String vehicleNumber) {
		repo.changeYesAvailability(vehicleNumber);
	}

	@Override
	public BookingEntity getAllDriverBookings(String vehicleNumber) {
		return repo.getAllDriversBooking(vehicleNumber);
	}

	@Override
	public UserEntity getUserDetails(String emailId) {
		return repo.getUserDetails(emailId);
	}

}
