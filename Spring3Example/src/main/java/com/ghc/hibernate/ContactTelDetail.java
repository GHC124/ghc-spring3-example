/**
 * ContactTelDetail.java
 * Feb 19, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;


/**
 * @author ChungPV1
 * 
 */
@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail implements Serializable {
	private static final long serialVersionUID = 6491635101341214986L;
	private Long mId;
	private int mVersion;
	private String mTelType;
	private String mTelNumber;

	private Contact mContact;

	@ManyToOne
	@JoinColumn(name = "CONTACT_ID")
	public Contact getContact() {
		return this.mContact;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return mId;
	}

	public void setId(Long id) {
		this.mId = id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return mVersion;
	}

	public void setVersion(int version) {
		this.mVersion = version;
	}

	@Column(name = "TEL_TYPE")
	public String getTelType() {
		return mTelType;
	}

	public void setTelType(String telType) {
		this.mTelType = telType;
	}

	@Column(name = "TEL_NUMBER")
	public String getTelNumber() {
		return mTelNumber;
	}

	public void setTelNumber(String telNumber) {
		this.mTelNumber = telNumber;
	}

	public void setContact(Contact contact) {
		this.mContact = contact;
	}

	public String toString() {
		return "Contact Tel Detail - Id: " + mId + ", Contact id: "
				+ getContact().getId() + ", Type: " + mTelType + ", Number: "
				+ mTelNumber;
	}
}
