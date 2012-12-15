package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class AbstractDAO<T extends Serializable> {
	private Class<T> clazz;

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	public void setClazz(final Class<T> classToSet) {
		this.clazz = classToSet;
	}

	public T findById(final String id) {
		return this.entityManager.find(clazz, id);
	}
	
	public List<T> findAll() {
		return this.entityManager.createQuery("from "+clazz.getName(), clazz).getResultList();
	}
	
	@Transactional
	public void save(final T entity) {
		System.out.println("**************************************"+entityManager);
		entityManager.getTransaction().begin();
		this.entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}
	
	public void update(final T entity) {
		entityManager.getTransaction().begin();
		this.entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}
	
	public void delete(final T entity) {
		entityManager.getTransaction().begin();
		this.entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}
	
	public void deleteById(final String id) {
		final T entity = findById(id);
		delete(entity);
	}
} 
