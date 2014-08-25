package com.samplecontact.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="contact_t")
public class Contact extends BaseEntity{

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
