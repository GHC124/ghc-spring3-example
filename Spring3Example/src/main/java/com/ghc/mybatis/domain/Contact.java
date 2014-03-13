/**
 * Contact.java
 *
 *	
 */
package com.ghc.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class Contact implements Serializable {
	private static final long serialVersionUID = -5707097388584411501L;
	private Long mId;
	private String mFirstName;
	private String mLastName;
	private Date mBirthDate;

	public Long getId() {
		return mId;
	}

	public void setId(Long id) {
		mId = id;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}

	public Date getBirthDate() {
		return mBirthDate;
	}

	public void setBirthDate(Date birthDate) {
		mBirthDate = birthDate;
	}

	public String toString() {
		return "Contact - Id: " + mId + ", First name: " + mFirstName
				+ ", Last name: " + mLastName + ", Birthday: " + mBirthDate;
	}
}
