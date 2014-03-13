/**
 * ContactService.java
 *
 *	
 */
package com.ghc.jpa;

import java.util.List;


/**
 * @author ChungPV1
 *
 */
public interface ContactService {
	// Find all contacts
	List<Contact> findAll();
	// Find all contacts with telephone and hobbies
	List<Contact> findAllWithDetail();
	List<Contact> findAllByNativeQuery();
	// Find a contact with details by id
	Contact findById(Long id);
	// Insert or update a contact
	Contact save(Contact contact);
	// Delete a contact
	void delete(Contact contact);
	List<Contact> findByCriteriaQuery(String firstName, String lastName);	
	
	Long countAll();
}
