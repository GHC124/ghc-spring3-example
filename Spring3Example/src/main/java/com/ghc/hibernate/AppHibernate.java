/**
 * AppHibernate.java
 *
 *	
 */
package com.ghc.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.ghc.AppBase;

/**
 * 
 */
public class AppHibernate implements AppBase {

	/* (non-Javadoc)
	 * @see com.ghc.AppBase#execute(java.lang.String[])
	 */
	@Override
	public void execute(String[] args, ApplicationContext ctx) {		
		ContactDAO contactDAO = (ContactDAO)ctx.getBean("contactDao", ContactDAO.class); 
		List<Contact> contacts = contactDAO.findAll();
		for (Contact c : contacts) {
			System.out.println(c);
		}		
	}

}
