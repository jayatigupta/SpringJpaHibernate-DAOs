package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SelectDemo {

	public static void main(String [] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("walmartpu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Customer customer = entityManager.find(Customer.class, 2);
		
		System.out.println(customer.getName());

		entityManager.getTransaction().begin();
		entityManager.remove(customer);
		entityManager.getTransaction().commit();

		System.out.println(customer.getName());

	}
}
