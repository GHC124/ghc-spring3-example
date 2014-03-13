/**
 * ContactRepository.java
 *
 *	
 */
package com.ghc.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ghc.jpa.Contact;

/**
 * 
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {
	@Query("select count(c) from Contact c")
	Long countAllContacts();
}
