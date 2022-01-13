package com.github.hyagomv;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQL8-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		Create
//		entityManager.getTransaction().begin();
//		entityManager.persist(new Customer("Bob"));
//		entityManager.getTransaction().commit();
		
//		Update
//		entityManager.getTransaction().begin();
//		entityManager.merge(new Customer(1, "Mary"));
//		entityManager.getTransaction().commit();
		
		
//		Read
//		Customer c = entityManager.find(Customer.class, 1);
//		System.out.println(c.getId());
//		System.out.println(c.getName());
		
		entityManager.
		
//		Delete
//		Customer c = entityManager.find(Customer.class, 1);
//		entityManager.getTransaction().begin();
//		entityManager.remove(c);
//		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
