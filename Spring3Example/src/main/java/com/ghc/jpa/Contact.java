/**
 * Contact.java
 *
 *	
 */
package com.ghc.jpa;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * 
 */
@Entity
@Table(name="contact")
@NamedQueries({
@NamedQuery(name="Contact.findAll", query="select c from Contact c"),
@NamedQuery(name="Contact.findById", query="select distinct c from Contact c left join fetch c.contactTelDetails t left join fetch c.hobbies h where c.id = :id"),
@NamedQuery(name="Contact.findAllWithDetail", query="select distinct c from Contact c left join fetch c.contactTelDetails t left join fetch c.hobbies h")
})
public class Contact implements Serializable {
	private static final long serialVersionUID = -5707097388584411501L;
	private Long mId;
	private int mVersion;
	private String mFirstName;
	private String mLastName;	
	private Date mBirthDate;

	private Set<ContactTelDetail> mContactTelDetails = new HashSet<>();
	private Set<Hobby> mHobbies = new HashSet<>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return this.mId;
	}

	public void setId(Long id) {
		this.mId = id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return this.mVersion;
	}

	public void setVersion(int version) {
		this.mVersion = version;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.mFirstName;
	}

	public void setFirstName(String firstName) {
		this.mFirstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.mLastName;
	}

	public void setLastName(String lastName) {
		this.mLastName = lastName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	public Date getBirthDate() {
		return this.mBirthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.mBirthDate = birthDate;
	}

	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<ContactTelDetail> getContactTelDetails() {
		return this.mContactTelDetails;
	}

	public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
		this.mContactTelDetails = contactTelDetails;
	}

	public void addContactTelDetail(ContactTelDetail contactTelDetail) {
		contactTelDetail.setContact(this);
		getContactTelDetails().add(contactTelDetail);
	}

	public void removeContactTelDetail(ContactTelDetail contactTelDetail) {
		getContactTelDetails().remove(contactTelDetail);
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "contact_hobby_detail", joinColumns = @JoinColumn(name = "CONTACT_ID"), inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
	public Set<Hobby> getHobbies() {
		return this.mHobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.mHobbies = hobbies;
	}

	public String toString() {
		return "Contact - Id: " + mId + ", First name: " + mFirstName
				+ ", Last name: " + mLastName + ", Birthday: " + mBirthDate;
	}
}
