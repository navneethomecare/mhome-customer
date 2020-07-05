package com.mhomecare.customer.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

public class Persistence {
	/**
	 * Use this constructor when Spring injects the EntityManager dependency
	 */
	public Persistence() {
	}

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		entityManager = em;
	}

	public void begin() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	@Transactional
	public Object saveObjectToDb(Object obj) {
		entityManager.persist(obj);
		entityManager.flush();
		return obj;
	}

	public Object mergeObjectToDb(Object obj) {
		return merge(obj, Object.class);
	}

	private <T> T merge(T object, Class<T> clazz) {
		T result = entityManager.merge(object);
		entityManager.flush();
		return result;
	}
}
