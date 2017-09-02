package com.yb.hdback.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.service.ICommonServiceImpl;
import com.yb.hd.entity.Hdusertable;
import com.yb.hdback.service.IUserService;


@Service("/iuserService")
@Transactional
public class IUserServiceImpl extends ICommonServiceImpl implements
		IUserService {

	public Hdusertable getUserInfoById(String id) {
		String hql = "from Hdusertable where id='"+id+"'";
		List<Hdusertable>userlist=this.queryByhql(hql);
		if(userlist.size()>0){
			return userlist.get(0);
		}else{
		    return null;
		}
	}

}
