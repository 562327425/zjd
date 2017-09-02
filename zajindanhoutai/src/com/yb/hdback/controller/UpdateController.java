package com.yb.hdback.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@RequestMapping("/updateController")
public class UpdateController {

	
	@Autowired
	private IHuodongService ihuodongService;
	
	@Autowired
	private IWentiService iwentiService;
	
	@RequestMapping(params="adminadd=admin")
	public String adminadd(){
		
		return "admin-add";
		
	}

	@RequestMapping(params="adminadd2=admin2")
	public String adminadd2(){
		
		return "admin-add2";
		
	}
	
	@RequestMapping(params="adminadd3=admin3")
	public String adminadd3(){
		
		return "admin-add3";
		
	}	
	
	@RequestMapping(params="memberadd=membadd")
	public String memberadd(){
		
		return "member-add2";
		
	}

	@RequestMapping(params="adminadd4=admin4")
	public String adminadd4(){
		
		return "admin-add4";
		
	}	

	@RequestMapping(params="adminadd5=admin5")
	public String adminadd5(){
		
		return "admin-add5";
		
	}	
	
	@RequestMapping(params="hdinfo=hd")
	@ResponseBody
	public AjaxReturn pdhdinfo(HttpServletRequest req){

		String hdid =req.getParameter("hdid");
	
		String hdname =req.getParameter("hdname");
		
		String starttime =req.getParameter("commentdatemin");
		
		String endtime =req.getParameter("commentdatemax");
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println(endtime);
		AjaxReturn ajax = new AjaxReturn();
		if(ihuodongService.getHuodonginfoByHdid(hdid)!= null){
				
			Hdinfo hdlist = ihuodongService.getHuodonginfoByHdid(hdid);
			hdlist.setHdname(hdname);
			try {
				hdlist.setStarttime(sf.parse(starttime));
				hdlist.setEndtime(sf.parse(endtime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			 ihuodongService.updata(hdlist);
			 ajax.setFlag(0);
			 ajax.setMeta("success");
			}else{
				ajax.setFlag(1);
				ajax.setMeta("fail");
		}
	 
		
		return ajax;
		
	}

	@RequestMapping(params="hdinfojx=jx")
	@ResponseBody	
	public AjaxReturn hdinfojx(HttpServletRequest req){
		String hdid =req.getParameter("hdid");
		String yidengjiang = req.getParameter("yidengjiang");
		String yicount =req.getParameter("yicount");
		String yizhongjiang =req.getParameter("yizhongjiang");
		String erdengjiang =req.getParameter("erdengjiang");
		String ercount =req.getParameter("ercount");
		String erzhongjiang =req.getParameter("erzhongjiang");
		String sandengjiang =req.getParameter("sandengjiang");
		String sancount =req.getParameter("sancount");
		String sanzhongjiang =req.getParameter("sanzhongjiang");
		AjaxReturn ajax = new AjaxReturn();	
		if(ihuodongService.getHuodonginfoByHdid(hdid)!= null){
			Hdinfo hdlist = ihuodongService.getHuodonginfoByHdid(hdid);

			hdlist.setYidengjiang(yidengjiang);
			System.out.println("----------------------");
			hdlist.setYicount(Integer.parseInt(yicount));
			hdlist.setYizhongjiang(yizhongjiang);
			hdlist.setErdengjiang(erdengjiang);
			hdlist.setErcount(Integer.parseInt(ercount));
			hdlist.setErzhongjiang(erzhongjiang);
			hdlist.setSandengjiang(sandengjiang);
			hdlist.setSancount(Integer.parseInt(sancount));
			hdlist.setSanzhongjiang(sanzhongjiang);			
			
			 ihuodongService.updata(hdlist);
			 ajax.setFlag(0);
			 ajax.setMeta("success");			
			
		}else{

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
		System.out.println(txuanxiang);
		if(iwentiService.getHdwentiInfoById(tid)!=null){
			Hdwenti wtlist = iwentiService.getHdwentiInfoById(tid);
			
			wtlist.setTitle(title);
			wtlist.setTxuanxiang(txuanxiang);
			wtlist.setDdaan(ddaan);
			try {
				wtlist.setAddtime(sd.parse(addtime));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			wtlist.setHdid(hdid);
			
			iwentiService.updata(wtlist);
			ajax.setFlag(0);
			ajax.setMeta("success");
		}else{
			ajax.setFlag(1);
			ajax.setMeta("faile");
		}
		
		return ajax;
		
	}
	
	
	
}
