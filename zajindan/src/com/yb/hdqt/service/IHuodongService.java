package com.yb.hdqt.service;

import java.util.List;

import com.yb.common.service.ICommonService;
import com.yb.hd.entity.Hdinfo;
import com.yb.hd.entity.Hduserzilist;

public interface IHuodongService extends ICommonService {
	
	public<T> List<T> getStartHuodong();
    public boolean isCanyuToday(String uid, String hdid);
    public Hdinfo getHuoDongInfoByid(String hdid);
    public Hduserzilist iszhongjiang(String hdid,String uid);
    public int getYuZhongjiangCountByNum(String hdid,int num);
    public<T> List<T> getYuZhongjiangInfo(String usid);
    
}
