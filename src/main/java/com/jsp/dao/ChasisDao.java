package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Chasis;

public class ChasisDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Chasis createChasis(Chasis chasis) {
		entityTransaction.begin();
		entityManager.persist(chasis);
		entityTransaction.commit();
		System.out.println("Charsheet Details Saved...");
		return chasis;
	}

	public Chasis getChasisById(int id) {
		Chasis c1 = entityManager.find(Chasis.class, id);

		return c1;
	}

	public Chasis deleteChasisById(int id) {
		Chasis c1 = entityManager.find(Chasis.class, id);

		entityTransaction.begin();
		entityManager.remove(c1);
		entityTransaction.commit();

		System.out.println("Charsheet Details deleted....");
		return c1;
	}

	public Chasis updateChasisById(int id, String owner_name, int chasis_no) {

		Chasis c1 = entityManager.find(Chasis.class, id);

		if (c1 != null) {
			c1.setOwner_name(owner_name);
			;
			c1.setChasis_no(id);
			entityTransaction.begin();
			entityManager.merge(c1);
			entityTransaction.commit();
		} else {
			System.out.println("charsheet details not found...");
		}
		return c1;
	}

}