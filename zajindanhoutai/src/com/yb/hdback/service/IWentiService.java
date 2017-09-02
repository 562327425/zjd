package com.yb.hdback.service;

import java.util.List;

import com.yb.common.service.ICommonService;
import com.yb.hd.entity.Hdhdlist;
import com.yb.hd.entity.Hdwenti;

public interface IWentiService extends ICommonService {

	public List<Hdwenti>getHdwentiList();
	public List<Hdhdlist>getHdhdlistList();
	public Hdwenti getHdwentiInfoById(String tid);
	public boolean isExsitEmpty(String tid);
	public Hdhdlist getHdhdlistByDid(String did);
}
