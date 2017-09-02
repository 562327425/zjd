package com.yb.hdback.service;

import com.yb.common.service.ICommonService;
import com.yb.hd.entity.Hdusertable;

public interface IUserService extends ICommonService {

	public Hdusertable getUserInfoById(String id);
}
