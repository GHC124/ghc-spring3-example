/**
 * AppMyBatis.java
 *
 *	
 */
package com.ghc.mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.ghc.AppBase;
import com.ghc.mybatis.domain.Contact;

/**
 * 
 */
public class AppMyBatis implements AppBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.AppBase#execute(java.lang.String[],
	 * org.springframework.context.ApplicationContext)
	 */
	@Override
	public void execute(String[] args, ApplicationContext ctx) {
		ContactService contactService = (ContactService) ctx
				.getBean("contactService");
		List<Contact> contacts = contactService.findAll();
		listContacts(contacts);
	}

	private static void listContacts(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();
		}
	}

}
