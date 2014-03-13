/**
 * ContactServiceImpl.java
 *
 *	
 */
package com.ghc.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghc.mybatis.domain.Contact;
import com.ghc.mybatis.persistence.ContactMapper;

/**
 * 
 */
@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactMapper contactMapper;
	
	/* (non-Javadoc)
	 * @see com.ghc.mybatis.ContactService#findAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return contactMapper.findAll(); 
	}

	/* (non-Javadoc)
	 * @see com.ghc.mybatis.ContactService#findAllWithDetail()
	 */
	@Override
	public List<Contact> findAllWithDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ghc.mybatis.ContactService#findById(java.lang.Long)
	 */
	@Override
	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ghc.mybatis.ContactService#save(com.ghc.mybatis.Contact)
	 */
	@Override
	public Contact save(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ghc.mybatis.ContactService#delete(com.ghc.mybatis.Contact)
	 */
	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ghc.mybatis.ContactService#findByFirstNameAndLastName(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Contact> findByFirstNameAndLastName(String firstName,
			String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
