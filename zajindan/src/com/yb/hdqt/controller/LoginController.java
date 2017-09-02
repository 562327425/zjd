package com.yb.hdqt.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.yb.hd.entity.Hdinfo;
import com.yb.hd.entity.Hdusertable;
import com.yb.hd.entity.Hdwenti;
import com.yb.hdqt.service.IDaanService;
import com.yb.hdqt.service.IHuodongService;
import com.yb.hdqt.service.IWentiService;
import com.yb.hdqt.service.UsertableService;




@Controller
@RequestMapping("/loginContorller")
public class LoginController {
	
	@Autowired
	private IHuodongService ihuodongService;
	

	
	@Autowired
	private UsertableService usertableService;
	
	@Autowired
	private IWentiService iwentiService;
	
	@Autowired
	private IDaanService idaanService;
	
	@RequestMapping(params="login")
	public String login(HttpServletRequest request){
		
		List <Hdinfo> huodonglist = ihuodongService.getStartHuodong();

		String flag="";
		if(huodonglist.size()>0){
			flag = "1";
			
			request.setAttribute("huodong", huodonglist.get(0));

			
		}else{
			flag = "0";
		}
		request.setAttribute("flag", flag);
		
		
		
		return "login";
	}

	@RequestMapping(params="hd=saveuser")
	public String savelogininfo(HttpServletRequest request,Hdusertable user){
		
		//判断用户是否当天登录,将userID跟时间保存到数据库
		if(null == usertableService.isExistEmpty(user))
		{
			
			user.setId(ihuodongService.getIdKey("user"));
			user.setUseraddtime(new Date());
			usertableService.save(user);		
		}else{
			user = usertableService.isExistEmpty(user);
			user.setUseraddtime(new Date());
			usertableService.updata(user);
		}
		
		
//		//  根据用户的电话与时间查询用户的ID号码
//		List<Hdusertable> ulist =  usertableService.getUserInfo(user.getUsertel());
//		
//		if(ulist.size() > 0 ){			
//			Hdusertable u = ulist.get(0);
//			request.setAttribute("u", u);						
//		}
//		
//		hdlist.setUid(ulist.get(0).getId());//这里也可以设置ID
//     
//		
//		
//		List <Hdinfo> huodonglist = ihuodongService.getStartHuodong();
//		
//		if(huodonglist.size()>0){
//			request.setAttribute("huodong", huodonglist.get(0));
//			
//		}

		//查询用户信息
		user=usertableService.isExistEmpty(user);
		HttpSession session =request.getSession();
		session.setAttribute("user", user);
		
		
		
		//查询问题，并展示
		List<Hdwenti> wentilist = iwentiService.getHdwentiList(user.getHdid());
		request.setAttribute("wentilist", wentilist);
		request.setAttribute("wentisize", wentilist.size());
		
		
		return "question1";
	}
	

	
}
