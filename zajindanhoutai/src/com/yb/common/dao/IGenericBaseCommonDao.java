package com.yb.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface IGenericBaseCommonDao {

	 //保存数据
	public <T> Serializable save(T entity);
	
	 //更新数据
	public <T> void updata(T entity);
	 //删除数据
	public <T> void delete(T entity);
	 //根据ID查询对象
	public <T> T getEntityId(Class classname,Serializable id);
	 //根据条件查询多对象
	public <T> List<T> getEntityListByProperty(Class<T> ClassName,String propertyName, Object object);
	 //SQL语句查询
	public <T> List<T> queryBySql(String sql,Class<T> classname);
	 //hql语句查询
	public <T> List<T> queryByhql(String hql);
	 //获得Session
	public Session getSession();
}
