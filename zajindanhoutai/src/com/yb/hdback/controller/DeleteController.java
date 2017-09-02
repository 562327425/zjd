package com.yb.hdback.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.hd.entity.Hdhdlist;
import com.yb.hd.entity.Hdinfo;
import com.yb.hd.entity.Hdusertable;
import com.yb.hd.entity.Hduserzilist;
import com.yb.hd.entity.Hdwenti;
import com.yb.hd.po.AjaxReturn;
import com.yb.hdback.service.IHuodongService;
import com.yb.hdback.service.IUserService;
import com.yb.hdback.service.IWentiService;

@Controller
@RequestMapping("/deleteController")
public class DeleteController {

	@Autowired
	private IHuodongService ihuodongService;
	
	@Autowired
	private IUserService iuserService;
	
	@Autowired
	private IWentiService iwentiService;

	@RequestMapping(params = "del=hdinfo")
	public String deleteHdinfo(HttpServletRequest req) {


		return "admin-role1";

	}

	//删除活动信息
	@RequestMapping(params = "let=hd")
	@ResponseBody
	public AjaxReturn delHdinfo(HttpServletRequest req) {

		String hdid = req.getParameter("hdid");
		System.out.println(hdid);
		Hdinfo hdinfo = ihuodongService.getHuodonginfoByHdid(hdid);
		hdinfo.setHdid(hdid);
		ihuodongService.delete(hdinfo);

		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");

		return ajax;

	}
	
	//批量删除活动信息
	@RequestMapping(params ="del=tt")
	@ResponseBody
	public AjaxReturn delHdlist(HttpServletRequest req) {
		
		String hdidlist =req.getParameter("hdidlist");
		System.out.println(hdidlist);
		
        int hdlist=hdidlist.length();
        System.out.println(hdlist);
		
		for (int i = 0; i < hdlist; i++) {
			String hds=hdidlist.substring(i, i+1);
			Hdinfo hdinfo = ihuodongService.getHuodonginfoByHdid(hds);
			hdinfo.setHdid(hds);
			ihuodongService.delete(hdinfo);
		}
	
		
		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");
		return ajax;
				
	}
	
	//删除参与活动用户信息
	@RequestMapping(params="userdel=us")
	@ResponseBody
    public AjaxReturn deljx(HttpServletRequest req){
    	
		String uid =req.getParameter("uid");
		
		Hdusertable hdlist = iuserService.getUserInfoById(uid);
		
		hdlist.setId(uid);
		iuserService.delete(hdlist);
    	
		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");

		return ajax;
    	
    }
	
	//批量删除参与活动用户信息
	@RequestMapping(params="listuser=list")
	@ResponseBody
    public AjaxReturn userlist(HttpServletRequest req){
    	
		String uid =req.getParameter("uid");
		System.out.println(uid);
		String[] userlist = uid.split("/");
		for (int i = 0; i < userlist.length; i++) {
			Hdusertable hdlist = iuserService.getUserInfoById(userlist[i]);
			hdlist.setId(userlist[i]);
			iuserService.delete(hdlist);
		}
//		int uidled= uid.length()/21;
//		for (int i = 0; i < uidled; i++) {
//			int j=0;
//			String userid = uid.substring(j, j+21);
//			System.out.println(userid);
//			Hdusertable hdlist = iuserService.getUserInfoById(userid);
//			hdlist.setId(userid);
//			iuserService.delete(hdlist);
//			j=j+22;
//		}
		    	
		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");
		return ajax;
    	
    }
	
	//删除活动问答题
	@RequestMapping(params="hdwt=wt")
	@ResponseBody
	public AjaxReturn hdwentilist(HttpServletRequest req){
		
		String tid =req.getParameter("tid");
		Hdwenti hdwt= iwentiService.getHdwentiInfoById(tid);
		hdwt.setTid(tid);
		iwentiService.delete(hdwt);

		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");	

		return ajax;
	}
	
	//批量删除活动问答题
	@RequestMapping(params="wtary=wt")
	@ResponseBody
	public AjaxReturn hdwentiarry(HttpServletRequest req){
		
		String tidlt = req.getParameter("tid");
		String [] tidlist =tidlt.split("/");
		for (int i = 0; i < tidlist.length; i++) {
			Hdwenti hdwt = iwentiService.getHdwentiInfoById(tidlist[i]);
			hdwt.setTid(tidlist[i]);
			iwentiService.delete(hdwt);
		}
		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");		
		return ajax;
			
		
	}
	
	//删除回答问题用户
	@RequestMapping(params="delhduser=hduser")
	@ResponseBody
	public AjaxReturn hdhduser(HttpServletRequest req){
		
		String did =req.getParameter("did");
		Hdhdlist hduser = iwentiService.getHdhdlistByDid(did);
		hduser.setDid(did);
		iwentiService.delete(hduser);
		
		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");		
		return ajax;	
		
		
	}
	
	//批量删除回答问题用户
	@RequestMapping(params="hdlistdel=list")
	@ResponseBody
	public AjaxReturn hdhduserlist(HttpServletRequest req){
		
		String hdidlist = req.getParameter("hdidlist");
		String [] hduserlist = hdidlist.split("/");
		for (int i = 0; i < hduserlist.length; i++) {
			Hdhdlist hduser = iwentiService.getHdhdlistByDid(hduserlist[i]);
			hduser.setDid(hduserlist[i]);
			iwentiService.delete(hduser);
		}
		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");		
		return ajax;
		
	}
	
	//删除中奖用户
	@RequestMapping(params="hdzjuser=del")
	@ResponseBody
	public AjaxReturn hdzjuser(HttpServletRequest req){
		
		String hduser =req.getParameter("hduser");
		Hduserzilist hduses=ihuodongService.getHduserzilistByID(hduser);
		hduses.setId(hduser);
		ihuodongService.delete(hduses);
		
		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");		
		return ajax;
		
	}
	
	//批量删除中奖用户
	@RequestMapping(params="hdzjlist=user")
	@ResponseBody
	public AjaxReturn hdzjuserlist(HttpServletRequest req){
		
		String hdidlist =req.getParameter("hdidlist");
		String[]hduserlist =hdidlist.split("/");
		for (int i = 0; i < hduserlist.length; i++) {
			Hduserzilist hduser= ihuodongService.getHduserzilistByID(hduserlist[i]);
			hduser.setId(hduserlist[i]);
			ihuodongService.delete(hduser);
		}
		
		AjaxReturn ajax = new AjaxReturn();
		ajax.setFlag(0);
		ajax.setMeta("success");		
		return ajax;
		
	}
	
	
	
}
