package com.samplecontact.entity;

import javax.persistence.Entity;

@Entity
public class Relation extends BaseEntity{

	private Long contatId;
	private Long groupId;
	
	/**
	 * @return the contatId
	 */
	public Long getContatId() {
		return contatId;
	}
	/**
	 * @param contatId the contatId to set
	 */
	public void setContatId(Long contatId) {
		this.contatId = contatId;
	}
	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	
}
