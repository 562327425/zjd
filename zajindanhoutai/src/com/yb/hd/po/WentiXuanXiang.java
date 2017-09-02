package com.yb.hd.po;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class WentiXuanXiang  implements java.io.Serializable  {
	
	
	private String tflag;
	private String txuanxiang;
	public String getTflag() {
		return tflag;
	}
	public void setTflag(String tflag) {
		this.tflag = tflag;
	}
	public String getTxuanxiang() {
		return txuanxiang;
	}
	public void setTxuanxiang(String txuanxiang) {
		this.txuanxiang = txuanxiang;
	}
	
	 public static List<WentiXuanXiang> jsonToObjectList(String jsonArrstr){
		 
		 List<WentiXuanXiang> list = new  ArrayList<WentiXuanXiang>();
		 JSONArray jsonArray = JSONArray.parseArray(jsonArrstr);
		 for (int i = 0; i < jsonArray.size(); i++) {
			 JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			 WentiXuanXiang xx = new WentiXuanXiang();
			 xx.setTflag(jsonObject.getString("tflag"));
			 xx.setTxuanxiang(jsonObject.getString("ttitle"));
			 list.add(xx);
		}
		return list;
	 }
	
	

}
