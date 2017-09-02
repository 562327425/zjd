package com.yb.hd.entity;

// Generated 2017-7-8 20:53:35 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Hdinfo generated by hbm2java
 */
@Entity
@Table(name = "hdinfo", catalog = "zjddatabase")
public class Hdinfo implements java.io.Serializable {

	private String hdid;
	private String hdname;
	private Date starttime;
	private Date endtime;
	private String yidengjiang;
	private int yicount;
	private String yizhongjiang;
	private String erdengjiang;
	private int ercount;
	private String erzhongjiang;
	private String sandengjiang;
	private int sancount;
	private String sanzhongjiang;

	public Hdinfo() {
	}

	public Hdinfo(String hdid, String hdname, Date starttime, Date endtime,
			String yidengjiang, int yicount, String yizhongjiang,
			String erdengjiang, int ercount, String erzhongjiang,
			String sandengjiang, int sancount, String sanzhongjiang) {
		this.hdid = hdid;
		this.hdname = hdname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.yidengjiang = yidengjiang;
		this.yicount = yicount;
		this.yizhongjiang = yizhongjiang;
		this.erdengjiang = erdengjiang;
		this.ercount = ercount;
		this.erzhongjiang = erzhongjiang;
		this.sandengjiang = sandengjiang;
		this.sancount = sancount;
		this.sanzhongjiang = sanzhongjiang;
	}

	@Id
	@Column(name = "hdid", unique = true, nullable = false, length = 30)
	public String getHdid() {
		return this.hdid;
	}

	public void setHdid(String hdid) {
		this.hdid = hdid;
	}

	@Column(name = "hdname", nullable = false, length = 20)
	public String getHdname() {
		return this.hdname;
	}

	public void setHdname(String hdname) {
		this.hdname = hdname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "starttime", nullable = false, length = 19)
	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endtime", nullable = false, length = 19)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Column(name = "yidengjiang", nullable = false, length = 20)
	public String getYidengjiang() {
		return this.yidengjiang;
	}

	public void setYidengjiang(String yidengjiang) {
		this.yidengjiang = yidengjiang;
	}

	@Column(name = "yicount", nullable = false)
	public int getYicount() {
		return this.yicount;
	}

	public void setYicount(int yicount) {
		this.yicount = yicount;
	}

	@Column(name = "yizhongjiang", nullable = false, length = 20)
	public String getYizhongjiang() {
		return this.yizhongjiang;
	}

	public void setYizhongjiang(String yizhongjiang) {
		this.yizhongjiang = yizhongjiang;
	}

	@Column(name = "erdengjiang", nullable = false, length = 20)
	public String getErdengjiang() {
		return this.erdengjiang;
	}

	public void setErdengjiang(String erdengjiang) {
		this.erdengjiang = erdengjiang;
	}

	@Column(name = "ercount", nullable = false)
	public int getErcount() {
		return this.ercount;
	}

	public void setErcount(int ercount) {
		this.ercount = ercount;
	}

	@Column(name = "erzhongjiang", nullable = false, length = 20)
	public String getErzhongjiang() {
		return this.erzhongjiang;
	}

	public void setErzhongjiang(String erzhongjiang) {
		this.erzhongjiang = erzhongjiang;
	}

	@Column(name = "sandengjiang", nullable = false, length = 20)
	public String getSandengjiang() {
		return this.sandengjiang;
	}

	public void setSandengjiang(String sandengjiang) {
		this.sandengjiang = sandengjiang;
	}

	@Column(name = "sancount", nullable = false)
	public int getSancount() {
		return this.sancount;
	}

	public void setSancount(int sancount) {
		this.sancount = sancount;
	}

	@Column(name = "sanzhongjiang", nullable = false, length = 20)
	public String getSanzhongjiang() {
		return this.sanzhongjiang;
	}

	public void setSanzhongjiang(String sanzhongjiang) {
		this.sanzhongjiang = sanzhongjiang;
	}

}
