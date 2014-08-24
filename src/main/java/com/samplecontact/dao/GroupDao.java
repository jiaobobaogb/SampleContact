package com.samplecontact.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.inject.Singleton;
import com.samplecontact.entity.Group;

@Singleton
public class GroupDao extends BaseHibernateDao<Group>{

	@Inject
	private RelationDao relationDao;
	
	@Inject
	private GroupDao groupDao;
	
	public Group getGroup(Long id) {
		Group group = (Group) get(id);
		return group;
	}
	
	public boolean saveGroup(String groupName) {
		Group group = new Group();
		group.setGroupName(groupName);
		save(group);
		return true;
	}

	public boolean updateGroup(Long id, String groupName) {
		Group group = (Group) get(id);
		group.setGroupName(groupName);
		update(group);
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
		delete(group);
		relationDao.deleteGroup(groupId);
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
