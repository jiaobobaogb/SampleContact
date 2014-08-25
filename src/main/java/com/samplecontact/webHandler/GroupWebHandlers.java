package com.samplecontact.webHandler;

import java.util.List;

import javax.inject.Inject;

import com.britesnow.snow.web.param.annotation.WebParam;
import com.britesnow.snow.web.rest.annotation.WebPost;
import com.google.inject.Singleton;
import com.samplecontact.dao.GroupDao;
import com.samplecontact.entity.Group;

@Singleton
public class GroupWebHandlers {

	@Inject
	private GroupDao groupDao;

	@WebPost("/group/listAllGroups")
	public List<Group> listAllGroups() {
		List<Group> groups = groupDao.listGroups();
		return groups;
	}

	@WebPost("/group/getGroupInfo")
	public Group getGroupInfo(@WebParam("groupId") Long groupId) {
		Group group = groupDao.getGroup(groupId);
		return group;
	}

	@WebPost("/group/createGroup")
	public boolean createGroup(@WebParam("groupName") String groupName) {
		return groupDao.saveGroup(groupName);
	}

	@WebPost("/group/updateGroupInfo")
	public boolean updateGroupInfo(@WebParam("groupId") Long groupId, @WebParam("groupName") String groupName) {
		return groupDao.updateGroup(groupId, groupName);
	}

	@WebPost("/group/deleteGroup")
	public boolean deleteGroup(@WebParam("groupId") Long groupId) {
		return groupDao.deleteGroup(groupId);
	}

}
