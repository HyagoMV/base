package com.github.hyagomv;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main3 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQL8-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpsql = "select c from Customer c";
		TypedQuery<Customer> typedQuery= entityManager.createQuery(jpsql, Customer.class);
		List<Customer> list = typedQuery.getResultList();
		list.forEach(System.out::println);
		
		
//		Update
//		entityManager.getTransaction().begin();
//		Query query = entityManager.createQuery("update Customer set name = :name where id = :id");
//		query.setParameter("name", "Bob");
//		query.setParameter("id", 1);
//		query.executeUpdate();
//		entityManager.getTransaction().commit();

//		Delete
//		entityManager.getTransaction().begin();
//		Query query = entityManager.createQuery("delete from Customer c where c.id = :id");
//		query.setParameter("id", 1);
//		query.executeUpdate();
//		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
