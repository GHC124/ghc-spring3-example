/**
 * ContactDAO.java
 * Feb 18, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.jdbc;

import java.util.List;

/**
 * @author ChungPV1
 *
 */
public interface ContactDAO {
	public List<Contact> findAll();
	public List<Contact> findByFirstName(String firstName);
	public void insert(Contact contact);
	public void update(Contact contact);
	public void delete(Long contactId);
}
