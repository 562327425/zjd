package com.yb.hdqt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.service.ICommonServiceImpl;
import com.yb.hd.entity.Hdwenti;
import com.yb.hd.po.WentiXuanXiang;

@Service("iwentiService")
@Transactional
public class IWentiServiceImpl extends ICommonServiceImpl implements
		IWentiService {

	public List<Hdwenti> getHdwentiList(String hdid) {
		
		String hql="from Hdwenti where hdid="+hdid;
		
		List<Hdwenti> wtlist =this.queryByhql(hql);
		
		for(int i=0; i<wtlist.size();i++){
			Hdwenti wt =wtlist.get(i);
			
			List<WentiXuanXiang>xuanxiang=WentiXuanXiang.jsonToObjectList(wt.getTxuanxiang());
			
			wtlist.get(i).setXuanxiang(xuanxiang);
		}
		
		
		return wtlist;
	}

}
