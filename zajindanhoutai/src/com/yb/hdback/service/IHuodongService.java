package com.yb.hdback.service;

import java.util.List;

import com.yb.common.service.ICommonService;
import com.yb.hd.entity.Hdinfo;
import com.yb.hd.entity.Hdusertable;
import com.yb.hd.entity.Hduserzilist;

public interface IHuodongService extends ICommonService {

	public List<Hdinfo> getHuodonginfo();
	public List<Hdusertable> getuserinfo();
	public List<Hduserzilist> getHduserzilistinfo();
	public Hdinfo getHuodonginfoByHdid(String hdid);
	public boolean HdinfoisExistEmpty(String hdid);
	public Hduserzilist getHduserzilistByID(String id);
	public List<Hdusertable> getuserinfo(String m,String n);
}
