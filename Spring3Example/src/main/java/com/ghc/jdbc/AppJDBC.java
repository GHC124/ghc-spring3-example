/**
 * AppJDBC.java
 *
 *	
 */
package com.ghc.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.ghc.AppBase;

/**
 * 
 */
public class AppJDBC implements AppBase {

	/* (non-Javadoc)
	 * @see com.ghc.AppBase#execute(java.lang.String[])
	 */
	@Override
	public void execute(String[] args, ApplicationContext ctx) {
		ContactDAO contactDAO = new PlainContactDaoImpl();
		List<Contact> contacts = contactDAO.findAll();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}

}
