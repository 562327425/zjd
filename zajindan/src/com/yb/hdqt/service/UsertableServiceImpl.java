package com.yb.hdqt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.service.ICommonServiceImpl;
import com.yb.hd.entity.Hdusertable;


@Service("usertableService")
@Transactional

public class UsertableServiceImpl extends ICommonServiceImpl implements
		UsertableService {

	public Hdusertable isExistEmpty(Hdusertable user) {
		
		String hql="from Hdusertable where usertel ="+user.getUsertel()+"and hdid="+user.getHdid()+"and date_format(useraddtime,'%Y%m%d') =  date_format(NOW(),'%Y%m%d')";
		
		List<Hdusertable> ulist =this.queryByhql(hql);
		
		if(ulist.size()>0){
			return ulist.get(0);
		}else{
			return null;
		}
				
	}
	
public <T> List<Hdusertable> getUserInfo(String usertel) {
		
		String hql=" from Hdusertable where usertel = '"+usertel+"' AND DATE_FORMAT(useraddtime,'yyyyMMdd') = DATE_FORMAT(NOW(),'yyyyMMdd') ";
		
		return this.queryByhql(hql);
	}

}
