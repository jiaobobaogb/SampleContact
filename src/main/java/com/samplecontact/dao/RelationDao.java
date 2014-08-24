package com.samplecontact.dao;

import java.util.List;

import com.google.inject.Singleton;
import com.samplecontact.entity.Relation;

@Singleton
public class RelationDao extends BaseHibernateDao<Relation>{

	public Relation getRelation (Long id) {
		Relation group = (Relation) get(id);
		return group;
	}
	
	public boolean saveRelation (Long contactId, Long groupId) {
		Relation relation = new Relation();
		relation.setContatId(contactId);
		relation.setGroupId(groupId);
		save(relation);
		return true;
	}

	public boolean updateRelation (Long id, Long contactId, Long groupId) {
		Relation relation = get(id);
		relation.setContatId(contactId);
		relation.setGroupId(groupId);
		update(relation);
		return true;
	}

	public boolean deleteRelation (Long relationId) {
		Relation relation = getRelation(relationId);
		delete(relation);
		return true;
	}
	
	public List<Long> listContactGroupIds(Long contactId) {
		int maxId = count().intValue();
		List<Long> groupIds = (List<Long>) daoHelper.find(0, maxId, "select destinct groupId from " + entityClass.getSimpleName() + "where contatId = ?" , contactId);
		return groupIds;
	}
	
	public List<Long> listGroupContactIds(Long groupId) {
		int maxId = count().intValue();
		List<Long> contatIds = (List<Long>) daoHelper.find(0, maxId, "select destinct contatId from " + entityClass.getSimpleName() + "where groupId = ?" , groupId);
		return contatIds;
	}
	
	public boolean deleteContact(Long contactId){
		int maxId = count().intValue();
		List<Long> relationIds = (List<Long>) daoHelper.find(0, maxId, "select destinct relationId from " + entityClass.getSimpleName() + "where contatId = ?" , contactId);
		for(Long relationId : relationIds){
			deleteRelation(relationId);
		}
		return true;
	}
	
	public boolean deleteGroup(Long groupId){
		int maxId = count().intValue();
		List<Long> relationIds = (List<Long>) daoHelper.find(0, maxId, "select destinct relationId from " + entityClass.getSimpleName() + "where groupId = ?" , groupId);
		for(Long relationId : relationIds){
			deleteRelation(relationId);
		}
		return true;
	}
}
