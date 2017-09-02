package com.yb.hd.entity;

// Generated 2017-7-10 20:49:12 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.yb.hd.po.WentiXuanXiang;

/**
 * Hdwenti generated by hbm2java
 */
@Entity
@Table(name = "hdwenti", catalog = "zjddatabase")
public class Hdwenti implements java.io.Serializable {

	private String tid;
	private String title;
	private String txuanxiang;
	private String ddaan;
	private Date addtime;
	private String hdid;
	private String adduser;
	private String remark;

	private List<WentiXuanXiang> xuanxiang;

	@Transient
	public List<WentiXuanXiang> getXuanxiang() {
		return xuanxiang;
	}

	public void setXuanxiang(List<WentiXuanXiang> xuanxiang) {
		this.xuanxiang = xuanxiang;
	}

	public Hdwenti() {
	}

	public Hdwenti(String tid, String title, String txuanxiang, String ddaan,
			Date addtime, String hdid) {
		this.tid = tid;
		this.title = title;
		this.txuanxiang = txuanxiang;
		this.ddaan = ddaan;
		this.addtime = addtime;
		this.hdid = hdid;
	}

	public Hdwenti(String tid, String title, String txuanxiang, String ddaan,
			Date addtime, String hdid, String adduser, String remark) {
		this.tid = tid;
		this.title = title;
		this.txuanxiang = txuanxiang;
		this.ddaan = ddaan;
		this.addtime = addtime;
		this.hdid = hdid;
		this.adduser = adduser;
		this.remark = remark;
	}

	@Id
	@Column(name = "tid", unique = true, nullable = false, length = 50)
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	@Column(name = "title", nullable = true, length = 120)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "txuanxiang", nullable = true, length = 200)
	public String getTxuanxiang() {
		return this.txuanxiang;
	}

	public void setTxuanxiang(String txuanxiang) {
		this.txuanxiang = txuanxiang;
	}

	@Column(name = "ddaan", nullable = true, length = 200)
	public String getDdaan() {
		return this.ddaan;
	}

	public void setDdaan(String ddaan) {
		this.ddaan = ddaan;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "addtime", nullable = true, length = 19)
	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	@Column(name = "hdid", nullable = true, length = 100)
	public String getHdid() {
		return this.hdid;
	}

	public void setHdid(String hdid) {
		this.hdid = hdid;
	}

	@Column(name = "adduser", length = 30)
	public String getAdduser() {
		return this.adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	@Column(name = "remark", length = 30)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}