package com.yb.hdback.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.service.ICommonServiceImpl;
import com.yb.hd.entity.Hdinfo;
import com.yb.hd.entity.Hdusertable;
import com.yb.hd.entity.Hduserzilist;
import com.yb.hdback.service.IHuodongService;

@Service("ihuodongService")
@Transactional
public class IHuodongServiceImpl extends ICommonServiceImpl implements
		IHuodongService {

	public List<Hdinfo> getHuodonginfo() {
		String hql = "from Hdinfo";
		List <Hdinfo> hdinfo =this.queryByhql(hql);
		if(hdinfo.size()>0){
			return hdinfo;
		}else{
			return null;
		}
		
	}

	public List<Hdusertable> getuserinfo() {
		String hql ="from Hdusertable";
		List<Hdusertable>userlist =this.queryByhql(hql);
		if(userlist.size()>0){
			return userlist;
		}else{
		return null;
		}
	}

	public List<Hduserzilist> getHduserzilistinfo() {
		String hql ="from Hduserzilist";
		List <Hduserzilist> hdlist= this.queryByhql(hql);
		if(hdlist.size()>0){
			return hdlist;
		}else{
		return null;
	}
	}

	public Hdinfo getHuodonginfoByHdid(String hdid) {
		String hql ="from Hdinfo where hdid = '"+hdid+"'";
		List <Hdinfo>hdlist=this.queryByhql(hql);
		if(hdlist.size()>0){
			return hdlist.get(0);
		}else{
		return null;
		}
	}

	public boolean HdinfoisExistEmpty(String hdid) {
		String hql ="from Hdinfo where hdid = '"+hdid+"'";
		int num=this.queryByhql(hql).size();
		if(num==0){
			return true;
		}else{
		return false;
		}
	}

	public Hduserzilist getHduserzilistByID(String id) {
		String hql="from Hduserzilist where id='"+id+"'";
		List<Hduserzilist>userlist=this.queryByhql(hql);
		if(userlist.size()>0){
			return userlist.get(0);
		}else{
		return null;
		}
	}

	public List<Hdusertable> getuserinfo(String m,String n) {
		String hql ="from Hdusertable where date_format(useraddtime,'%Y%m%d') between date_format('"+m+"','%Y%m%d')and date_format('"+n+"','%Y%m%d')";
		List <Hdusertable> userlist =this.queryByhql(hql);
		if(userlist.size()>0){
			return userlist;
		}else{
			return null;
		}
	}


}
