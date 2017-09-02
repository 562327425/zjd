package com.yb.hdback.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.service.ICommonServiceImpl;
import com.yb.hd.entity.Admin;
import com.yb.hdback.service.IAdminService;


@Service("iadminService")
@Transactional
public class IAdminServiceImpl extends ICommonServiceImpl implements
		IAdminService {

	public Admin getpassword(String adminUser) {
		String hql ="FROM Admin WHERE adminUser ='"+adminUser+"'";
		List <Admin> adlist = this.queryByhql(hql);
		if(adlist.size()>0){
			return adlist.get(0);
		}else{
			return null;
		}
	}

}
