/**
 * ContactDaoImpl.java
 * Feb 19, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ChungPV1
 * 
 */
@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDAO {
	private Log log = LogFactory.getLog(ContactDaoImpl.class);
	
	private SessionFactory mSessionFactory;

	public SessionFactory getSessionFactory() {
		return mSessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.mSessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.hibernate.ContactDAO#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAll() {
		return mSessionFactory.getCurrentSession()
				.createQuery("from Contact c").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.hibernate.ContactDAO#findAllWithDetail()
	 */
	@Override
	public List<Contact> findAllWithDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.hibernate.ContactDAO#findById(java.lang.Long)
	 */
	@Override
	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.hibernate.ContactDAO#save(com.ghc.hibernate.Contact)
	 */
	@Override
	public Contact save(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.hibernate.ContactDAO#delete(com.ghc.hibernate.Contact)
	 */
	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub

	}

}
