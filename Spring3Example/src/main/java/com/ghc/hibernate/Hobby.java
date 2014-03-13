/**
 * Hobby.java
 * Feb 19, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author ChungPV1
 * 
 */
@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
	private static final long serialVersionUID = 4759024017871141033L;
	private String mHobbyId;
	private Set<Contact> mContacts = new HashSet<>();

	@Id
	@Column(name = "HOBBY_ID")
	public String getHobbyId() {
		return mHobbyId;
	}

	public void setHobbyId(String hobbyId) {
		mHobbyId = hobbyId;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "hobbies")
	public Set<Contact> getContacts() {
		return this.mContacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.mContacts = contacts;
	}

	@Override
	public String toString() {
		return "Hobby:" + mHobbyId;
	}
}
