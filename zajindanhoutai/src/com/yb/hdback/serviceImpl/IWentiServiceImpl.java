package com.yb.hdback.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.service.ICommonServiceImpl;
import com.yb.hd.entity.Hdhdlist;
import com.yb.hd.entity.Hdwenti;
import com.yb.hd.po.WentiXuanXiang;
import com.yb.hdback.service.IWentiService;

@Service("iwentiService")
@Transactional
public class IWentiServiceImpl extends ICommonServiceImpl implements
		IWentiService {
  
	public List<Hdwenti> getHdwentiList() {
		String hql ="from Hdwenti";

		List<Hdwenti> wtlist =this.queryByhql(hql);
		
		for(int i=0; i<wtlist.size();i++){
			Hdwenti wt =wtlist.get(i);
			if(wt.getTxuanxiang()!=null){
			List<WentiXuanXiang>xuanxiang=WentiXuanXiang.jsonToObjectList(wt.getTxuanxiang());			
			wtlist.get(i).setXuanxiang(xuanxiang);
			}else{
				return null;
			}
			
		}
		return wtlist;
	}

	public List<Hdhdlist> getHdhdlistList() {
		String hql ="from Hdhdlist";
		
		List<Hdhdlist> hdlist =this.queryByhql(hql);
		if(hdlist.size()>0){
			return hdlist;
		}else{
		return null;
		}
	}

	public Hdwenti getHdwentiInfoById(String tid) {
		String hql ="from Hdwenti where tid='"+tid+"'";
		
		List <Hdwenti> hdlist =this.queryByhql(hql);
		if(hdlist.size()>0){
			return hdlist.get(0);
		}else{
		return null;
		}
	}

	public boolean isExsitEmpty(String tid) {
		String hql ="from Hdwenti where tid='"+tid+"'";
		
		int num = this.queryByhql(hql).size();
		if(num==0){
			return true;
		}else{
		    return false;
		}
	}

	public Hdhdlist getHdhdlistByDid(String did) {
		String hql ="from Hdhdlist where did='"+did+"'";
		
		List<Hdhdlist>hduser=this.queryByhql(hql);
		if(hduser.size()>0){
			return hduser.get(0);
		}else{
		return null;
		}
	}


}
