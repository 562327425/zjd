package com.yb.hdback.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.yb.hdback.service.IWentiService;

@Controller
@RequestMapping("/IndexController")
public class IndexController {

	@Autowired
	IHuodongService ihuodongService;
	@Autowired
	IWentiService iwentiService;

	@RequestMapping(params = "index=in")
	public String index() {

		return "maindesk";
	}

	@RequestMapping(params = "hdinfo=hd")
	public String hdinfo(HttpServletRequest req, Hdinfo hdinfo) {

		return "maindesk";
	}

	@RequestMapping(params = "role1=hd")
	public String adminrole1(HttpServletRequest request, Hdinfo hdinfo) {

		List<Hdinfo> hdlist = ihuodongService.getHuodonginfo();
		request.setAttribute("hdlist", hdlist);
		request.setAttribute("hdsize", hdlist.size());
		return "admin-role1";
	}

	@RequestMapping(params = "memberdel1=del")
	public String memberdel1(HttpServletRequest request) {

		List<Hdinfo> hdlist = ihuodongService.getHuodonginfo();
		request.setAttribute("hdlist", hdlist);

		return "member-del1";
	}

	@RequestMapping(params = "adminlist=adlist")
	public String adminlist(HttpServletRequest request) {

		List<Hdusertable> userlist = ihuodongService.getuserinfo();
		request.setAttribute("userlist", userlist);
		request.setAttribute("userlistsize", userlist.size());
		return "admin-list";
	}

	@RequestMapping(params = "memberlist1t=meblist")
	public String memberlist1(HttpServletRequest request) {

		List<Hdwenti> wentilist = iwentiService.getHdwentiList();
		request.setAttribute("wentilist", wentilist);
		request.setAttribute("wentilistsize", wentilist.size());
		return "member-list1";
	}

	@RequestMapping(params = "adminlisthd1=adlist1")
	public String adminlist1(HttpServletRequest request) {

		List<Hdhdlist> hdlist = iwentiService.getHdhdlistList();
		request.setAttribute("hdlist", hdlist);
		request.setAttribute("hdlistsize", hdlist.size());
		return "admin-list1";
	}

	@RequestMapping(params = "adminlist2=adlist2")
	public String adminlist2(HttpServletRequest request) {

		List<Hduserzilist> zjlist = ihuodongService.getHduserzilistinfo();
		request.setAttribute("zjlist", zjlist);
		request.setAttribute("zjlistsize", zjlist.size());
		return "admin-list2";
	}

	@RequestMapping(params = "sousuo=so")
	@ResponseBody
	public AjaxReturn sousuo(HttpServletRequest request) {

		String datemin = request.getParameter("datemin");
		String datemax = request.getParameter("datemax");

		AjaxReturn ajax = new AjaxReturn();
		if (datemin == null || "".equals(datemin) || datemax == null
				|| "".equals(datemax)) {
			ajax.setFlag(1);
			ajax.setMeta("fail");
		} else {
			ajax.setFlag(0);
			ajax.setMeta("success");
		}

		HttpSession session = request.getSession();
		session.setAttribute("datemin", datemin);
		session.setAttribute("datemax", datemax);

		return ajax;

	}

	@RequestMapping(params = "userso=uo")
	public String userso(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String datemin = (String) session.getAttribute("datemin");
		String datemax = (String) session.getAttribute("datemax");
		System.out.println(datemin);
		System.out.println(datemax);
		List<Hdusertable> userlist = ihuodongService.getuserinfo(datemin,datemax);
		request.setAttribute("userlist", userlist);

		return "admin-list3";

	}

}
