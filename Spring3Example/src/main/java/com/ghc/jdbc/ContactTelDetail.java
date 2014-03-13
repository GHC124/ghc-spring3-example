/**
 * ContactTelDetail.java
 * Feb 18, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.jdbc;

import java.io.Serializable;

/**
 * @author ChungPV1
 * 
 */
public class ContactTelDetail implements Serializable {
	private static final long serialVersionUID = -441565013430791067L;
	private Long id;
	private Long contactId;
	private String telType;
	private String telNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getTelType() {
		return telType;
	}

	public void setTelType(String telType) {
		this.telType = telType;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Getter and setter method omitted
	public String toString() {
		return "Contact Tel Detail - Id: " + id + ", Contact id: " + contactId
				+ ", Type: " + telType + ", Number: " + telNumber;
	}
}
