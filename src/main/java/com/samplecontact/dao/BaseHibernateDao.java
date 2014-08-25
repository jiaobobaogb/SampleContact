package com.samplecontact.dao;

import java.lang.reflect.Type;

import com.britesnow.snow.web.db.hibernate.HibernateDaoHelper;
import com.google.inject.Inject;
import com.googlecode.gentyref.GenericTypeReflector;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class BaseHibernateDao<E> {

    protected Class<E> entityClass;
    
    public enum SortOrder {
        ASC, DESC
    }
    @Inject
    protected HibernateDaoHelper daoHelper;

    public BaseHibernateDao() {
        Type persistentType = GenericTypeReflector.getTypeParameter(getClass(), BaseHibernateDao.class.getTypeParameters()[0]);
        if (persistentType instanceof Class) {
            this.entityClass = (Class<E>) persistentType;
        } else {
            throw new IllegalStateException("concrete class " + getClass().getName()
                    + " must have a generic binding for interface "
                    + BaseHibernateDao.class.getName());
        }
    }

    public Long count() {
    	String query = "select count(*) from " + entityClass.getSimpleName() + " where 1=1";
        return (Long) daoHelper.findFirst(query);
    }

}