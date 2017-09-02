package com.yb.hdqt.service;

import java.util.List;

import com.yb.hd.entity.Hdwenti;

public interface IWentiService {

	
	//根据活动ID查询问题
	public List<Hdwenti> getHdwentiList(String hdid);
}
