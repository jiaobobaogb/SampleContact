package com.samplecontact.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="relation_t")
public class Relation extends BaseEntity{

	private Long contactId;
	private Long groupId;
	
	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
