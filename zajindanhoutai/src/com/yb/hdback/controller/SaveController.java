package com.yb.hdback.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.hd.entity.Hdinfo;
import com.yb.hd.entity.Hdwenti;
import com.yb.hd.po.AjaxReturn;
import com.yb.hdback.service.IHuodongService;
import com.yb.hdback.service.IWentiService;


@Controller
@RequestMapping("/saveController")
public class SaveController {

	
	@Autowired
	private IHuodongService ihuodongService;
	
	@Autowired
	private IWentiService iwentiService;
	
	@RequestMapping(params="addhdinfo=info")
	public String addHdinfo(){
		
		
		return "addhdinfo";
	}
	
	@RequestMapping(params="addhdjx=jx")
	public String addjiangx(){
		
		return "addhdjx";
	}
	
	@RequestMapping(params="addwt=wt")
	public String addquestion(){
		
		return "addwt2";
	}
	
	
	@RequestMapping(params="addhdinfo=add")
	@ResponseBody
	public AjaxReturn pdhdinfo(HttpServletRequest req){

		String hdid =req.getParameter("hdid");
	
		String hdname =req.getParameter("hdname");
		
		String starttime =req.getParameter("commentdatemin");
		
		String endtime =req.getParameter("commentdatemax");
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
		AjaxReturn ajax = new AjaxReturn();

		if(ihuodongService.HdinfoisExistEmpty(hdid)){
			//前台传入ID为空
			Hdinfo hdinfo =new Hdinfo();
			hdinfo.setHdid(hdid);
			hdinfo.setHdname(hdname);
			try {
				hdinfo.setStarttime(sf.parse(starttime));
				hdinfo.setEndtime(sf.parse(endtime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ihuodongService.save(hdinfo);
			ajax.setFlag(0);
			ajax.setMeta("success");
		}else{
		  	//前台传入ID不为空
			ajax.setFlag(1);
			ajax.setMeta("fail");
		}
	 
		
		return ajax;
		
	}
	
	@RequestMapping(params="hdwenti=wt")
	@ResponseBody
	public AjaxReturn hdwenti(HttpServletRequest req){
		
		String tid =req.getParameter("tid");
		String title =req.getParameter("title");
		String strst =req.getParameter("strst");
		String ddaan =req.getParameter("ddaan");
		String addtime =req.getParameter("addtime");
		String hdid =req.getParameter("hdid");
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		AjaxReturn ajax = new AjaxReturn();	
		String txuanxiang ='['+strst+']';
			if(tid!=null && iwentiService.isExsitEmpty(tid) && txuanxiang!=null){
				Hdwenti hdwt = new Hdwenti();
				hdwt.setTid(tid);
				hdwt.setTitle(title);
				hdwt.setTxuanxiang(txuanxiang);
				hdwt.setDdaan(ddaan);
				try {
					hdwt.setAddtime(sd.parse(addtime));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hdwt.setHdid(hdid);
				iwentiService.save(hdwt);
				ajax.setFlag(0);
				ajax.setMeta("success");
			}else{
				ajax.setFlag(1);
				ajax.setMeta("fail");
			}
		
        
		return ajax;
		
	}	
	
}
