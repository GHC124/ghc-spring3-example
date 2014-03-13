/**
 * ContactService.java
 *
 *	
 */
package com.ghc.mybatis;

import java.util.List;

import com.ghc.mybatis.domain.Contact;


/**
 * @author ChungPV1
 *
 */
public interface ContactService {
	// Find all contacts
	List<Contact> findAll();
	// Find all contacts with telephone and hobbies
	List<Contact> findAllWithDetail();
	// Find a contact with details by id
	Contact findById(Long id);
	// Insert or update a contact
	Contact save(Contact contact);
	// Delete a contact
	void delete(Contact contact);
	List<Contact> findByFirstNameAndLastName(String firstName, String lastName);	
}
