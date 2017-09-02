package com.yb.hdqt.service;



import com.yb.common.service.ICommonService;
import com.yb.hd.entity.Hdhdlist;
import com.yb.hd.entity.Hdusertable;


public interface IHdlistService extends ICommonService {

      public Hdhdlist getHdhdlist(Hdusertable user);
      public int getCanyuHodongCount(String hdid);
      
     
}
