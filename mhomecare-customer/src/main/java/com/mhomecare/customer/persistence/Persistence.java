package com.mhomecare.customer.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import com.mhomecare.customer.model.Customer;
import com.mhomecare.customer.model.Login;
import com.mhomecare.customer.model.Profile;

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

	public List<Customer> getAllCustomers() {
		List<Customer> results = entityManager.createQuery("select c from Customer c where deleted = 0",Customer.class).getResultList();
		if (results.size() > 0) {
			return results;
		}
		return null;
	}
	
	public Customer getCustomerById(String customerId){
		List<Customer> results = entityManager.createQuery("select c from Customer c where c.id = :customerId and deleted = 0",Customer.class)
				.setParameter("customerId", customerId)
				.getResultList();
		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
	
	public Login findCustomerByPhoneNumber(String phoneNumber){
		List<Login> results = entityManager.createQuery("select l from Login l where l.phoneNumber = :phoneNumber",Login.class)
				.setParameter("phoneNumber", phoneNumber)
				.getResultList();
		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
	
	public Customer checkCustomerPhoneNumberDulicateOrNot(String phoneNumber){
		List<Customer> results = entityManager.createQuery("select l from Customer l where l.phoneNumber = :phoneNumber",Customer.class)
				.setParameter("phoneNumber", phoneNumber)
				.getResultList();
		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
	
	public Profile checkProfilePhoneNumberDulicateOrNot(String phoneNumber){
		List<Profile> results = entityManager.createQuery("select l from Profile l where l.phoneNumber = :phoneNumber",Profile.class)
				.setParameter("phoneNumber", phoneNumber)
				.getResultList();
		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
	
	public List<Profile> profileDetails(String customerId){
		List<Profile> results = entityManager.createQuery("select p from Profile p where p.customerId = :customerId",Profile.class)
				.setParameter("customerId", customerId)
				.getResultList();
		if (results.size() > 0) {
			return results;
		}
		return null;
	}
}
