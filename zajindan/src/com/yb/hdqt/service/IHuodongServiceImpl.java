package com.yb.hdqt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.service.ICommonServiceImpl;
import com.yb.hd.entity.Hdinfo;
import com.yb.hd.entity.Hduserzilist;



@Service("ihuodongService")
@Transactional

public class IHuodongServiceImpl extends ICommonServiceImpl implements
		IHuodongService {

	public <T> List<T> getStartHuodong() {
		String hql=" from Hdinfo where  starttime < now() and endtime > now()";
		return this.queryByhql(hql);
	}

	public boolean isCanyuToday(String uid, String hdid) {
		
		String hql = "from Hdhdlist where hdid= '"+hdid+"' and uid= '"+uid+"' and date_format(addtime,'%Y%m%d')= date_format(now(),'%Y%m%d')";
		int num= this.queryByhql(hql).size();
		if(num>0){
			return true;
		}else{
			return false;
		}
		
		
	}

	public Hdinfo getHuoDongInfoByid(String hdid) {
		String hql="from Hdinfo where hdid='"+hdid+"'";
		List <Hdinfo> hdinfo = this.queryByhql(hql);
		if(hdinfo.size()>0){
			return hdinfo.get(0);
		}else{
		return null;
		}
	}

	public Hduserzilist iszhongjiang(String hdid, String uid) {
		String hql ="from Hduserzilist where hdid='"+hdid+"'and uid='"+uid+"'";
		List<Hduserzilist>zjlist =this.queryByhql(hql);
		if(zjlist.size()>0){
			return zjlist.get(0);
		}else{
		return null;
		}
	}

	public int getYuZhongjiangCountByNum(String hdid, int num) {
		String hql ="from Hdyzhongjiang where hdid='"+hdid+"' and num='"+num+"'";
		
		return this.queryByhql(hql).size();
	}

	public <T> List<T> getYuZhongjiangInfo(String usid) {
		String hql ="from Hdyzhongjiang where usid='"+usid+"'";
		return this.queryByhql(hql);
	}


	 
}

