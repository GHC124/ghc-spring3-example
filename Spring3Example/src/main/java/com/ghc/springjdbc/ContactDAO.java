/**
 * ContactDAO.java
 * Feb 18, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.springjdbc;

import java.util.List;

import com.ghc.jdbc.Contact;

/**
 * @author ChungPV1
 *
 */
public interface ContactDAO {
	void insert(Contact contact);
	String getFirstNameById(long id);
	List<Contact> findAll();
	List<Contact> findAllWithDetail();
}
