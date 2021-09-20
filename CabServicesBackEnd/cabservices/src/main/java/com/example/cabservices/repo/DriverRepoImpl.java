package com.example.cabservices.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.validation.ValidationException;

import org.springframework.stereotype.Repository;

import com.example.cabservices.entities.DriverEntity;
import com.example.cabservices.exceptions.AlreadyPresentException;
import com.example.cabservices.exceptions.EmptyRecordException;
@Repository
public class DriverRepoImpl implements DriverRepo{

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean driverLogin(String vehicleNumber, String password) {
		int count = 0;
		String JPQL = "select a from DriverEntity a";
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(JPQL);
		@SuppressWarnings("unchecked")
		List<DriverEntity> drivers = query.getResultList();
		manager.close();
		
		for (DriverEntity driver : drivers) {
			if ((driver.getVehicleNumber().equals(vehicleNumber)) && (driver.getPassword().equals(password))) {
				count++;
			}
		}
		if (count != 0 ) {
			return true;
		} else {
			throw new ValidationException();
		}	
		}

	

	@Override
	public boolean addDriver(DriverEntity driver) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(driver);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			throw new AlreadyPresentException();
		}
	}



//	@Override
//	public boolean addVehicle(VehicleEntity vehicle) {
//		EntityManager manager = emf.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		transaction.begin();
//		try {
//			manager.persist(vehicle);
//			transaction.commit();
//			return true;
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//			throw new AlreadyPresentException();
//		}
//	}



	@Override
	public List<DriverEntity> getAllVehicle() {
		String JPQL = "select l from DriverEntity l";
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(JPQL);
		@SuppressWarnings("unchecked")
		List<DriverEntity> list = query.getResultList();
		manager.close();
		if(list.isEmpty()) {
			throw new EmptyRecordException();
		}
		else {
			return list;
		}
	}



	@Override
	public List<DriverEntity> getPriceDetails(String vehicleNumber) {
		String JPQL = "select d from DriverEntity d where  d.vehicleNumber=:vehicleNumber";
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(JPQL);
		query.setParameter("vehicleNumber", vehicleNumber);

		@SuppressWarnings("unchecked")
		List<DriverEntity> list = query.getResultList();
		manager.close();
		if(list.isEmpty()) {
			throw new EmptyRecordException();
		}
		else {
			return list;
		}
	}

}
