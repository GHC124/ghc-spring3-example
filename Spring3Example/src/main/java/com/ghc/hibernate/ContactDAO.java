/**
 * ContactDAO.java
 * Feb 19, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.hibernate;

import java.util.List;

/**
 * @author ChungPV1
 *
 */
public interface ContactDAO {
	// Find all contacts
	public List<Contact> findAll();
	// Find all contacts with telephone and hobbies
	public List<Contact> findAllWithDetail();
	// Find a contact with details by id	
	public Contact findById(Long id);
	// Insert or update a contact
	public Contact save(Contact contact);
	// Delete a contact
	public void delete(Contact contact);
}
