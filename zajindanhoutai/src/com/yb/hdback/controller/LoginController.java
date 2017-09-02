package com.yb.hdback.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.hd.po.AjaxReturn;
import com.yb.hdback.service.IAdminService;

@Controller
@RequestMapping("/loginController")
public class LoginController {

	@Autowired
	private IAdminService iadminService;
	
	@RequestMapping(params="login=login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(params="login=lo")
	@ResponseBody
	public AjaxReturn loginpd(HttpServletRequest req){
		
		String username = req.getParameter("username");
		System.out.println(username);
		String password = req.getParameter("password");
		System.out.println(password);
		AjaxReturn ajax = new AjaxReturn();
		if(iadminService.getpassword(username)!=null){
			
			String pasd =iadminService.getpassword(username).getAdminpassword().trim();
			System.out.println(pasd);
			if(pasd == null){
				ajax.setFlag(1);
				ajax.setMeta("fail");
			}else if(password.equals(pasd)){
						ajax.setFlag(0);
						ajax.setMeta("success");
			}else{
					ajax.setFlag(1);
					ajax.setMeta("fail");			
				}			
		}
		else{
			ajax.setFlag(1);
			ajax.setMeta("fail");	
		};
		
		return ajax;
		
	}
}
