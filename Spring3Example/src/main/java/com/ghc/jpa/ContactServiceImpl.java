/**
 * ContactServiceImpl.java
 *
 *	
 */
package com.ghc.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 */
@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	@PersistenceContext
	private EntityManager mEntityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = mEntityManager.createNamedQuery(
				"Contact.findAll", Contact.class).getResultList();
		return contacts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findAllWithDetail()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAllWithDetail() {
		List<Contact> contacts = mEntityManager.createNamedQuery(
				"Contact.findAllWithDetail", Contact.class).getResultList();
		return contacts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Contact findById(Long id) {
		TypedQuery<Contact> query = mEntityManager.createNamedQuery(
				"Contact.findById", Contact.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#save(com.ghc.hibernate.Contact)
	 */
	@Override
	public Contact save(Contact contact) {
		if (contact.getId() == null) {
			mEntityManager.persist(contact);
		} else {
			mEntityManager.merge(contact);
		}
		return contact;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#delete(com.ghc.hibernate.Contact)
	 */
	@Override
	public void delete(Contact contact) {
		Contact contact2 = mEntityManager.merge(contact);
		mEntityManager.remove(contact2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findAllByNativeQuery()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAllByNativeQuery() {
		String query = "select id, first_name, last_name, birth_date, version from contact";
		return mEntityManager.createNativeQuery(query, Contact.class)
				.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findByCriteriaQuery(java.lang.String,
	 * java.lang.String)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = mEntityManager.getCriteriaBuilder();
		CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
		Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
		contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
		contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
		criteriaQuery.select(contactRoot).distinct(true);

		Predicate criteria = cb.conjunction();

		// First Name
		if (firstName != null) {
			Predicate p = cb.equal(contactRoot.get(Contact_.firstName),
					firstName);
			criteria = cb.and(criteria, p);
		}
		// Last Name
		if (lastName != null) {
			Predicate p = cb
					.equal(contactRoot.get(Contact_.lastName), lastName);
			criteria = cb.and(criteria, p);
		}
		criteriaQuery.where(criteria);
		List<Contact> result = mEntityManager.createQuery(criteriaQuery)
				.getResultList();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ghc.jpa.ContactService#countAll()
	 */
	@Override
	public Long countAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
