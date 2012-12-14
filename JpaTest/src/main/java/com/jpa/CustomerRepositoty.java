package com.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerRepositoty {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(Customer customer) {
		entityManager.persist(customer);
	}
	
	public Customer getCustomerById(int id) {
		return entityManager.find(Customer.class, id);
	}
	
	public List<Customer> getAllCustomers() {
		String query ="from Customer";
		TypedQuery <Customer> query2 = entityManager.createQuery(query, Customer.class);
		return query2.getResultList();
	}
}
