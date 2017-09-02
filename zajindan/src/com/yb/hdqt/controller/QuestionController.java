package com.yb.hdqt.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
import com.yb.hd.entity.Hdyzhongjiang;

import com.yb.hd.po.AjaxReturn;
import com.yb.hdqt.service.IDaanService;
import com.yb.hdqt.service.IHdlistService;
import com.yb.hdqt.service.IHuodongService;
import com.yb.hdqt.service.UsertableService;


@Controller
@RequestMapping("/QuestionController")
public class QuestionController {
	
	@Autowired
	private IDaanService idaanService;

	
	@Autowired
	private IHuodongService ihuodongService;
	
	@Autowired
	private UsertableService usertableService;

	@Autowired
	private IHdlistService ihdlistService;
	
	@RequestMapping(params="panduan=save")
	public String daan(HttpServletRequest req,Hdhdlist hdlist){
		
	/* 进入砸蛋页面进行预抽奖*/	
	//记录活动参与表	
	  HttpSession session =req.getSession();
	  Hdusertable user =(Hdusertable) session.getAttribute("user");
	  
	//根据ID获得活动信息	
	  Hdinfo hdinfo = ihuodongService.getHuoDongInfoByid(user.getHdid());
	  
	  Hdhdlist hlist1 = ihdlistService.getHdhdlist(user);
	  
	  int zhongjiang = -1;
	  
	  //判断用户是否中奖
	  Hduserzilist zhongjianglist = ihuodongService.iszhongjiang(user.getHdid(), user.getId());
	  if(zhongjianglist != null){
		  //中奖
		  zhongjiang =zhongjianglist.getJiangx();
		  req.setAttribute("zhongjiang", -1);
		  
	  }else{
		  //一等奖
		  int num1 = ihuodongService.getYuZhongjiangCountByNum(user.getHdid(), 1);
		  if(num1<hdinfo.getYicount()){
			  //表示用户可以中一等奖
			  //比对一等奖规则
			  int canyu =  hlist1.getHdcount();
			  String yidengjiang = hdinfo.getYizhongjiang();
			  String [] yidjlist = yidengjiang.split("/");
			  for(int i = 0; i < yidjlist.length; i++){
				  if(yidjlist[i].trim().equals(canyu+"")){
				  zhongjiang =1;
				  req.setAttribute("zhongjiang", zhongjiang);
				  break;
			  }
		  }
	  }
	     if(zhongjiang<0){
	    	 //二等奖
	    	 int num2 = ihuodongService.getYuZhongjiangCountByNum(user.getHdid(), 2);
	    	 if(num2<hdinfo.getErcount()){
	    		 //表示用户可以中一等奖
	    		 //比对二等奖规则
	    		 int canyu =  hlist1.getHdcount();
	    		 String erdengjiang = hdinfo.getErzhongjiang();
	    		 String[] erdjlist = erdengjiang.split("/");
	    		 for(int j = 0; j<erdjlist.length; j++ ){
	    			 if(erdjlist[j].trim().equals(canyu+"")){
	    			 zhongjiang = 2;
	    			 req.setAttribute("zhongjiang", zhongjiang);
	    			 break;
	    			 
	    		 }
	    	 }
	    	 
	     }
	    	 
	     } 
	     //三等奖
	     if(zhongjiang<0){
	    	 int num3 = ihuodongService.getYuZhongjiangCountByNum(user.getHdid(), 3);
	    	 if(num3<hdinfo.getSancount()){
	    		 
	    		 String sandengjiang =hdinfo.getSanzhongjiang();
	    		 String[] sandjlist = sandengjiang.split("/");
	    		 int startnum=Integer.parseInt(sandjlist[0]);
	    		 int endnum=Integer.parseInt(sandjlist[1]);
	    		 Random random =new Random();
	    		 int genum =random.nextInt(endnum);
	    		 if(genum>0 && genum<startnum){
	    			 zhongjiang = 3;
	    			 req.setAttribute("zhongjiang", zhongjiang);
	    		 }else{
	    			 zhongjiang= -1;
	    			 req.setAttribute("zhongjiang", zhongjiang);
	    			}
			}else{
			//一定不会中奖
			zhongjiang=-1;
			req.setAttribute("zhongjiang", zhongjiang);
			
				}
			}
	     	    		     
	     //如果用户中奖插入预中奖表中
	     if(zhongjiang>0){
	    	 Hdyzhongjiang yzhongjiang = new Hdyzhongjiang();
	    	 yzhongjiang.setAddtime(new Date());
	    	 yzhongjiang.setNum(zhongjiang);
	    	 yzhongjiang.setUsid(user.getId());
	    	 yzhongjiang.setHdid(user.getHdid());
	    	 yzhongjiang.setYid(ihuodongService.getIdKey("YZ"));
	    	 ihuodongService.save(yzhongjiang);
	    	 
	     }
	     
	     
//		hdlist.setAddtime(new Date());
//		hdlist.setDid(usertableService.getIdKey("did"));
//		usertableService.save(hdlist);
	  }
	
		return "zajindan";
	}

	@RequestMapping(params="question=qt")	
	@ResponseBody
    public AjaxReturn pdquestion(HttpServletRequest req){
    	
    	List<String>ddaan=idaanService.getDaan();
    	System.out.println(ddaan);
                 
    	String  [] daan = req.getParameterValues("daan");
    	
    	
    	//查询数据库进行比较
    	boolean flag = true;
    	for(int i=0;i<daan.length;i++){
    		System.out.println(i);
			if(!(ddaan.get(i)).equals(daan[i])){
				flag = false;
				
				break;
			}
    	}
    	
    	//记录活动参与表
    	HttpSession session =req.getSession();
    	Hdusertable user = (Hdusertable) session.getAttribute("user");
    	
    	//判断用户当天是否参与
    	if(ihuodongService.isCanyuToday(user.getId(), user.getHdid())){
    		//参与过本活动
    		Hdhdlist hdlist = ihdlistService.getHdhdlist(user);
    		hdlist.setUcount(hdlist.getUcount()+1);
    		hdlist.setAddtime(new Date());
    		ihdlistService.updata(hdlist);
    		
    	}else{
    		//没有参与过活动
    		Hdhdlist hdlist =new Hdhdlist();
    		hdlist.setDid(ihdlistService.getIdKey("HD"));
    		hdlist.setUid(user.getId());
    		hdlist.setAddtime(new Date());
    		hdlist.setHdid(user.getHdid());
    		int count = ihdlistService.getCanyuHodongCount(user.getHdid())+1;
    		hdlist.setHdcount(count);
    		hdlist.setCjiangcount(0);
    		hdlist.setUcount(1);
    		ihdlistService.save(hdlist);
    		
    	}
    	
  
    	AjaxReturn ajax = new AjaxReturn();
    	if(flag){
    		ajax.setFlag(0);
    		ajax.setMeta("success");
    	}  else{
    		ajax.setFlag(1);
    		ajax.setMeta("error");
    	}
    	
    	
    	
		return ajax;
    	
    }
	
}
