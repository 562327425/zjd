package com.yb.hdqt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.service.ICommonServiceImpl;
import com.yb.hd.entity.Hdhdlist;
import com.yb.hd.entity.Hdusertable;


@Service("ihdlistService")
@Transactional
public class IHdlistServiceImpl extends ICommonServiceImpl implements
		IHdlistService {

	public Hdhdlist getHdhdlist(Hdusertable user) {

		String hql = "from Hdhdlist where hdid= '"+user.getHdid()+"' and uid= '"+user.getId()+"' and date_format(addtime,'%Y%m%d')= date_format(now(),'%Y%m%d')";		
		List <Hdhdlist> hlist =this.queryByhql(hql);
		if(hlist.size()>0){
			return hlist.get(0);
		}else{
		    return null;
		}
	}

	public int getCanyuHodongCount(String hdid) {
		String hql ="from Hdhdlist where hdid='"+hdid+"'";
		            
		return this.queryByhql(hql).size();
	}
	

}
