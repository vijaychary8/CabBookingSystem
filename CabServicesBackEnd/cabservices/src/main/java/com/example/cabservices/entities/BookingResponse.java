package com.example.cabservices.entities;

import java.util.List;

public class BookingResponse {
	
	private boolean isError;
	private String message;
	private BookingEntity booking;
	private List<BookingEntity> bookiList;
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
	public BookingEntity getBooking() {
		return booking;
	}
	public void setBooking(BookingEntity booking) {
		this.booking = booking;
	}
	public List<BookingEntity> getBookiList() {
		return bookiList;
	}
	public void setBookiList(List<BookingEntity> bookiList) {
		this.bookiList = bookiList;
	}


}
