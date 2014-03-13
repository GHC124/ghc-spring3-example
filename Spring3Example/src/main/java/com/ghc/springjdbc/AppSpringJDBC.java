/**
 * AppSpringJDBC.java
 *
 *	
 */
package com.ghc.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.ghc.AppBase;
import com.ghc.hibernate.Contact;
import com.ghc.hibernate.ContactDAO;

/**
 * 
 */
public class AppSpringJDBC implements AppBase {

	/* (non-Javadoc)
	 * @see com.ghc.AppBase#execute(java.lang.String[])
	 */
	@Override
	public void execute(String[] args, ApplicationContext ctx) {
//		DriverManagerDataSource dataSource = (DriverManagerDataSource)ctx.getBean("dataSource", DriverManagerDataSource.class);
//		JdbcContactDAOImpl contactDAO = new JdbcContactDAOImpl();
//		contactDAO.setDataSource(dataSource);
		
		ContactDAO contactDAO = (ContactDAO)ctx.getBean("contactDao", ContactDAO.class); 
		List<Contact> contacts = contactDAO.findAllWithDetail();
		for (Contact c : contacts) {
			System.out.println(c);
		}
		
//		System.out.println("//////////// Insert new Contact ///////////////");
//		Contact contact = new Contact();
//		contact.setFirstName("Chung");
//		contact.setLastName("Pham Van");		
//		contactDAO.insert(contact);
//		contacts = contactDAO.findAllWithDetail();
//		for (Contact c : contacts) {
//			System.out.println(c);
//		}
//		
//		System.out.println("//////////// Get First Name By ID ///////////////");
//		String firstName = contactDAO.getFirstNameById(2);
//		System.out.println("First Name: " + firstName);
	}

}
