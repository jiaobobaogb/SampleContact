package com.samplecontact.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.inject.Singleton;
import com.samplecontact.entity.Contact;
import com.samplecontact.entity.Group;

@Singleton
public class ContactDao extends BaseHibernateDao<Contact>{
	

	@Inject
	private RelationDao relationDao;
	
	@Inject
	private GroupDao groupDao;
	
	public Contact getContact(Long id) {
		Contact contact = get(id);
		return contact;
	}
	
	public boolean saveContact(String firstName, String lastName) {
		Contact contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		save(contact);
		return true;
	}

	public List<Contact> listContacts() {
		int maxId = count().intValue();
		List<Contact> contactList = (List<Contact>) daoHelper.find(0, maxId, "from " + entityClass.getSimpleName());
		return contactList;
	}

	public boolean updateContact(Long id, String firstName, String lastName) {
		Contact contact = get(id);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		update(contact);
		return true;
	}

	public boolean deleteContact(Long contactId) {
		Contact contact = getContact(contactId);
		delete(contact);
		relationDao.deleteContact(contactId);
		return true;
	}
	
	public boolean setContactGroups(Long contactId, ArrayList<Long> groupIds) {
		for(Long groupId : groupIds){
			relationDao.saveRelation(contactId, groupId);
		}
		return true;
	}
	
	
	public List<Group> getContactGroups(Long contactId){
		List<Long> groupIds = relationDao.listContactGroupIds(contactId);
		List<Group> groups = new ArrayList<Group>();
		for(Long groupId : groupIds){
			Group group = groupDao.get(groupId);
			groups.add(group);
		}
		return groups;
	}
}
