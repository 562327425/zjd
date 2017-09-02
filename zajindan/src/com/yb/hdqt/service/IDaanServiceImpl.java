package com.yb.hdqt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.common.service.ICommonServiceImpl;

@Service("idaanService")
@Transactional

public class IDaanServiceImpl extends ICommonServiceImpl implements
		IDaanService {

	public <T> List<T> getDaan() {
		
		String hql="select ddaan from Hdwenti" ;
		
		return this.queryByhql(hql);
	}

}
