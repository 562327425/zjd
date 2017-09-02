package com.yb.hdqt.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yb.hd.entity.Hdhdlist;
import com.yb.hd.entity.Hdusertable;
import com.yb.hd.entity.Hduserzilist;
import com.yb.hd.entity.Hdyzhongjiang;
import com.yb.hdqt.service.IHdlistService;
import com.yb.hdqt.service.IHuodongService;
import com.yb.hdqt.service.UsertableService;


@Controller
@RequestMapping("/ZaDanController")
public class ZaDanController {

	@Autowired
	private UsertableService usertableService;	

	@Autowired
	private IHdlistService ihdlistService;
	
	@Autowired
	private IHuodongService ihuodongService;
	@RequestMapping(params="zadan=save")
	public String zadan(HttpServletRequest req,Hduserzilist zjlist){

		  HttpSession session =req.getSession();
		  Hdusertable user =(Hdusertable) session.getAttribute("user");
		  
		  Hdhdlist hlist1 = ihdlistService.getHdhdlist(user);
		  List <Hdyzhongjiang> yzjlist =ihuodongService.getYuZhongjiangInfo(user.getId());
		  
		  zjlist.setId(yzjlist.get(0).getYid());
		  zjlist.setHdid(user.getHdid());
		  zjlist.setUid(user.getId());
		  zjlist.setLjiangtime(new Date());
		  zjlist.setUsetel(user.getUsertel());
		  zjlist.setHjitime(hlist1.getAddtime());
		  zjlist.setLingjiang(1);
		  usertableService.save(zjlist);
		  
		  hlist1.setCjiangcount(hlist1.getCjiangcount()+1);
		  ihdlistService.updata(hlist1);
		  
		  return "zajindan";
	}
	
}
