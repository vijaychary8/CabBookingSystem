package com.example.cabservices.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.validation.ValidationException;

import org.springframework.stereotype.Repository;

import com.example.cabservices.entities.BookingEntity;
import com.example.cabservices.entities.UserEntity;
import com.example.cabservices.exceptions.AlreadyPresentException;
import com.example.cabservices.exceptions.EmptyRecordException;
import com.example.cabservices.exceptions.NotFoundException;

@Repository

public class UserRepoImp implements UserRepo {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addUser(UserEntity user) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			throw new AlreadyPresentException();
		}
	}

	@Override
	public boolean userLogin(String emailId, String password) {
		int count = 0;
		String JPQL = "select a from UserEntity a";
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(JPQL);
		@SuppressWarnings("unchecked")
		List<UserEntity> userList = query.getResultList();
		manager.close();

		for (UserEntity user : userList) {
			if ((user.getEmailId().equals(emailId)) && (user.getPassword().equals(password))) {
				count++;
			}
		}
		if (count != 0) {
			return true;
		} else {
			throw new ValidationException();
		}
	}

	@Override
	public boolean addBooking(BookingEntity booking) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(booking);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			throw new AlreadyPresentException();
		}
	}

	@Override
	public BookingEntity getbooking(int bookingId) {
		String JPQL = "select l from BookingEntity l where l.bookingId=:bookingId";

		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery(JPQL);
		query.setParameter("bookingId", bookingId);
		try {
			BookingEntity record = (BookingEntity) query.getSingleResult();
			return record;

		} catch (NoResultException e) {
			throw new NotFoundException();
		}

	}

	@Override
	public List<BookingEntity> getAllBookings(String userName) {
		String JPQL = "select l from BookingEntity l where l.userName=:userName";
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(JPQL);
		query.setParameter("userName", userName);

		@SuppressWarnings("unchecked")
		List<BookingEntity> list = query.getResultList();
		manager.close();
		if (list.isEmpty()) {
			throw new EmptyRecordException();
		} else {
			return list;
		}

	}

	@Override
	public boolean deleteBooking(int bookingId) {
		String JPQL = "delete from BookingEntity l where l.bookingId=:bookingId";

		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery(JPQL);
		query.setParameter("bookingId", bookingId);
		int i = query.executeUpdate();
		transaction.commit();
		if (i != 0) {
			return true;
		}
		throw new NotFoundException();
	}

	@Override
	public void changeAvailability(String number) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String JPQL = "update DriverEntity l set l.isAvailable='No' where l.vehicleNumber=:number";
		Query query = manager.createQuery(JPQL);
		query.setParameter("number", number);

		query.executeUpdate();
		transaction.commit();

	}

	@Override
	public void changeYesAvailability(String vehicleNumber) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String JPQL = "update DriverEntity l set l.isAvailable='Yes' where l.vehicleNumber=:vehicleNumber";
		Query query = manager.createQuery(JPQL);
		query.setParameter("vehicleNumber", vehicleNumber);

		query.executeUpdate();
		transaction.commit();

		
	}

	@Override
	public BookingEntity getAllDriversBooking(String vehicleNumber) {
		String JPQL = "select l from BookingEntity l where l.vehicleNumber=:vehicleNumber";

		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery(JPQL);
		query.setParameter("vehicleNumber", vehicleNumber);
		try {
			BookingEntity record = (BookingEntity) query.getSingleResult();
			return record;

		} catch (NoResultException e) {
			throw new NotFoundException();
		}

	}

	@Override
	public UserEntity getUserDetails(String emailId) {
		String JPQL = "select l from UserEntity l where l.emailId=:emailId";

		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery(JPQL);
		query.setParameter("emailId", emailId);
		try {
			UserEntity record = (UserEntity) query.getSingleResult();
			return record;

		} catch (NoResultException e) {
			throw new NotFoundException();
		}
	}

}
