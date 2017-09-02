package com.yb.hdback.service;

import com.yb.common.service.ICommonService;
import com.yb.hd.entity.Admin;

public interface IAdminService extends ICommonService {

	public Admin getpassword(String adminUser);
}
