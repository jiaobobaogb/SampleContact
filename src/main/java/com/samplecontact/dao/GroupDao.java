package com.samplecontact.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.inject.Singleton;
import com.samplecontact.entity.Contact;
import com.samplecontact.entity.Group;

@Singleton
public class GroupDao extends BaseHibernateDao<Group>{

	@Inject
	private RelationDao relationDao;

	@Inject
	private ContactDao contactDao;
	
	public Group getGroup(Long id) {
		Group group = daoHelper.get(entityClass, id);
		return group;
	}
	
	public boolean saveGroup(String groupName) {
		Group group = new Group();
		group.setGroupName(groupName);
		daoHelper.save(group);
		return true;
	}

	public boolean updateGroup(Long id, String groupName) {
		Group group = daoHelper.get(entityClass, id);
		group.setGroupName(groupName);
		daoHelper.update(group);
		return true;
	}
	
	public List<Group> listGroups() {
		int maxId = count().intValue();
		List<Group> groupList = (List<Group>) daoHelper.find(0, maxId, "from " + entityClass.getSimpleName());
		return groupList;
	}
	
	public ArrayList<Long> getGroupIds() {
		ArrayList<Long> ids = new ArrayList<Long>();
		List<Group> groupList = listGroups();
		for (int i = 0; i < groupList.size(); i++) {
			ids.add(groupList.get(i).getId());
		}
		return ids;
	}

	public boolean deleteGroup(Long groupId) {
		Group group = getGroup(groupId);
		daoHelper.delete(group);
		relationDao.deleteGroup(groupId);
		return true;
	}
	
	public List<Contact> getGroupContacts(Long groupId){
		List<Long> contactIds = relationDao.listGroupContactIds(groupId);
		List<Contact> contacts = new ArrayList<Contact>();
		for(Long contactId : contactIds){
			Contact contact = contactDao.getContact(contactId);
			contacts.add(contact);
		}
		return contacts;
	}
}
