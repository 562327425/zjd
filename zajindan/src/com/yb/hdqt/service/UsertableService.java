package com.yb.hdqt.service;

import java.util.List;

import com.yb.common.service.ICommonService;
import com.yb.hd.entity.Hdusertable;

public interface UsertableService extends ICommonService {

	public Hdusertable isExistEmpty(Hdusertable user);
	public <T> List<Hdusertable> getUserInfo(String usertel);
}
