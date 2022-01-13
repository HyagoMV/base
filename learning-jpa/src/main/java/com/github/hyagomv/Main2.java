package com.github.hyagomv;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQL8-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		Update
//		entityManager.getTransaction().begin();
//		entityManager.unwrap(Session.class).update(new Customer(1, "Mary"));
//		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
