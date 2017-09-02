package com.yb.common.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;



import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.dao.ICommonDao;


@Service("ICommonService")
@Transactional

public class ICommonServiceImpl implements ICommonService {
	
	private ICommonDao common = null;
	
	@Resource
	public void setCommonDaoImpl(ICommonDao commonDaoImpl){
		this.common = commonDaoImpl;
	}

	public <T> Serializable save(T entity) {
		
		return common.save(entity);
		
	}

	public <T> void updata(T entity) {
		common.updata(entity);

	}

	public <T> void delete(T entity) {
		common.delete(entity);

	}

	public <T> T getEntityId(Class classname, Serializable id) {
		
		return common.getEntityId(classname, id);
	}

	public <T> List<T> getEntityListByProperty(Class<T> ClassName,
			String propertyName, Object object) {
		
		return common.getEntityListByProperty(ClassName, propertyName, object);
	}

	public <T> List<T> queryBySql(String sql, Class<T> classname) {
		
		return common.queryBySql(sql, classname);
	}

	public <T> List<T> queryByhql(String hql) {
		
		return common.queryByhql(hql);
	}

	public Session getSession() {
		
		return common.getSession();
	}

	public String getIdKey(String key) {
		Date date = new Date();
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMddhhmmss");
		String id = sdf.format(date);
		Random ro = new Random();
		int num = ro.nextInt(1000); 
		if(num < 10)
		{
			id +="00"+num;
		}else if(num<100){
			id += "0"+num;
		}else{
			id +=num;
		}
		id = key+id;
		return id;
	}

}
