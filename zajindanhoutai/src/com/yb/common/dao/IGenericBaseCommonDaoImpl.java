package com.yb.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class IGenericBaseCommonDaoImpl implements IGenericBaseCommonDao {
	
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactroy(){
		return sessionFactory;
	}

	public <T> Serializable save(T entity) {
		Serializable s=getSession().save(entity);
		getSession().flush();
		return s;
	}

	public <T> void updata(T entity) {
		 getSession().update(entity);
		 getSession().flush();

	}

	public <T> void delete(T entity) {
		getSession().delete(entity);
		getSession().flush();

	}

	public <T> T getEntityId(Class classname, Serializable id) {
		
		
		return (T) getSession().get(classname, id);
	}

	public <T> List<T> getEntityListByProperty(Class<T> ClassName,
			String propertyName, Object object) {
		Criteria c = getSession().createCriteria(ClassName);
		
		c.add(Restrictions.eq(propertyName, object));
		return (List<T>)c.list();
	}

	public <T> List<T> queryBySql(String sql, Class<T> classname) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> queryByhql(String hql) {
		Query query =getSession().createQuery(hql);
		return (List<T>)query.list();
	}

	public Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}

}
