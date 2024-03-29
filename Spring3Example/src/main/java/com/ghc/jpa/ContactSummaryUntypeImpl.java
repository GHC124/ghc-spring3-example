/**
 * ContactSummaryUntypeImpl.java
 *
 *	
 */
package com.ghc.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 */
@Service("contactSummaryUntype")
@Repository
@Transactional
public class ContactSummaryUntypeImpl {
	@PersistenceContext
	EntityManager mEntityManager;

	public void listContactSummary() {
		List result = mEntityManager
				.createQuery(
						"select c.firstName, c.lastName, t.telNumber from Contact c left join c.contactTelDetails t where t.telType='Home'")
				.getResultList();
		for (Iterator i = result.iterator(); i.hasNext();) {
			Object[] values = (Object[]) i.next();
			System.out.println(String.format(
					"First name: %s, Last name: %s, Tel number: %s", values[0],
					values[1], values[2]));
		}
	}
}
