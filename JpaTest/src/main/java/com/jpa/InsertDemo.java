package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsertDemo {

	public static void main (String [] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("walmartpu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Customer customer = new Customer();
		customer.setName("Puneet");
		customer.setCity("Bangalore");
		customer.setCountry("IN");
		
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
}
