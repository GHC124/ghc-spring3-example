/**
 * AppJPA.java
 *
 *	
 */
package com.ghc.jpa;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.ghc.AppBase;

/**
 * 
 */
public class AppJPA implements AppBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.AppBase#execute(java.lang.String[])
	 */
	@Override
	public void execute(String[] args, ApplicationContext ctx) {
		ContactService contactService = (ContactService) ctx.getBean(
				"contactTransaction", ContactService.class);
//		 List<Contact> contacts = contactService.findAll();
//		 for (Contact c : contacts) {
//			 System.out.println(c);
//		 }
		// contacts = contactService.findAllWithDetail();
		// listContactsWithDetail(contacts);

		// Contact contact = contactService.findById(new Long(2));
		// System.out.println(contact);

		// ContactSummaryUntypeImpl untypeImpl =
		// (ContactSummaryUntypeImpl)ctx.getBean("contactSummaryUntype",
		// ContactSummaryUntypeImpl.class);
		// untypeImpl.listContactSummary();
//		Contact contact = contactService.findById(new Long(1));
//		contact.setLastName("ChungPV1");
//		contactService.save(contact);
		
//		List<Contact> contacts = contactService.findAllWithDetail();
//		listContactsWithDetail(contacts);
//		
//		Contact contact = contactService.findById(new Long(1));		
//		contactService.delete(contact);
//		
//		contacts = contactService.findAllWithDetail();
//		listContactsWithDetail(contacts);
		
//		List<Contact> contacts = contactService.findAllByNativeQuery();
//		listContactsWithDetail(contacts);
		
//		Contact contact = new Contact();
//		contact.setFirstName("John");
//		contact.setLastName("ChungPV1");
//		contactService.save(contact);
//		
//		List<Contact> contacts = contactService.findByCriteriaQuery("John", null);
//		listContactsWithDetail(contacts);
		
		
		
	}

	private static void listContactsWithDetail(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact
						.getContactTelDetails()) {
					System.out.println(contactTelDetail);
				}
			}
			if (contact.getHobbies() != null) {
				for (Hobby hobby : contact.getHobbies()) {
					System.out.println(hobby);
				}
			}
		}
	}
}
