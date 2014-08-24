package com.samplecontact.entity;

import javax.persistence.Entity;

@Entity
public class Contact extends BaseEntity{

	private String firstName;
	private String lastName;
	private String groupIds;

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

	public String getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(String groupIds) {
		this.groupIds = groupIds;
	}

}
