/**
 * ContactTransactionImpl.java
 *
 *	
 */
package com.ghc.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghc.jpa.repository.ContactRepository;
import com.ghc.util.Lists;

/**
 * 
 */
@Service("contactTransaction")
@Repository
@Transactional
public class ContactTransactionImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findAllWithDetail()
	 */
	@Override
	public List<Contact> findAllWithDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findAllByNativeQuery()
	 */
	@Override
	public List<Contact> findAllByNativeQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findById(java.lang.Long)
	 */
	@Transactional(readOnly=true)
	@Override
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#save(com.ghc.jpa.Contact)
	 */
	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#delete(com.ghc.jpa.Contact)
	 */
	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jpa.ContactService#findByCriteriaQuery(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ghc.jpa.ContactService#countAll()
	 */
	@Override
	public Long countAll() {
		return contactRepository.countAllContacts();
	}

}
