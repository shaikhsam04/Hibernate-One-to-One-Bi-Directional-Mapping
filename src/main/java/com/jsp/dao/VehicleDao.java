package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Vehicle;

public class VehicleDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Vehicle createVehicle(Vehicle vehicle) {
		entityTransaction.begin();
		entityManager.persist(vehicle);
		entityTransaction.commit();
		System.out.println("Vehicle Details Saved...");
		return vehicle;
	}

	public Vehicle getVehicleById(int id) {
		Vehicle v1 = entityManager.find(Vehicle.class, id);

		return v1;
	}

	public Vehicle deleteVehicleById(int id) {
		Vehicle v1 = entityManager.find(Vehicle.class, id);

		entityTransaction.begin();
		entityManager.remove(v1);
		entityTransaction.commit();

		System.out.println("Vehicle Details deleted....");
		return v1;
	}

	public Vehicle updateVehicleById(int id, String name, String brand, int vehicle_no) {

		Vehicle v1 = entityManager.find(Vehicle.class, id);

		if (v1 != null) {
			v1.setName(name);
			v1.setBrand(brand);
			v1.setVehicle_no(vehicle_no);
			entityTransaction.begin();
			entityManager.merge(v1);
			entityTransaction.commit();
		} else {
			System.out.println("person details not found...");
		}
		return v1;
	}

}