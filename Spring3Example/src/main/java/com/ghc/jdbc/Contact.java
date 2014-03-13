/**
 * Contact.java
 * 
 * @author ChungPV1 
 *	
 */
package com.ghc.jdbc;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ChungPV1
 * 
 */
public class Contact implements Serializable {
	private static final long serialVersionUID = 6953756912262674514L;
	private Long mId;
	private String mFirstName;
	private String mLastName;
	private Date mBirthDate;
	private List<ContactTelDetail> mContactTelDetails;

	public Long getId() {
		return mId;
	}

	public void setId(Long id) {
		this.mId = id;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		this.mFirstName = firstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		this.mLastName = lastName;
	}

	public Date getBirthDate() {
		return mBirthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.mBirthDate = birthDate;
	}

	public List<ContactTelDetail> getContactTelDetails() {
		return mContactTelDetails;
	}

	public void setContactTelDetails(List<ContactTelDetail> contactTelDetails) {
		this.mContactTelDetails = contactTelDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Getter and setter method omitted
	public String toString() {
		String basic = "Contact - Id: " + mId + ", First name: " + mFirstName
				+ ", Last name: " + mLastName + ", Birthday: " + mBirthDate;

		if (mContactTelDetails != null && mContactTelDetails.size() > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (ContactTelDetail detail : mContactTelDetails) {
				sb.append(detail);
				sb.append(" ; ");
			}
			sb.append("]");
			basic += sb.toString();
		}

		return basic;
	}
}
