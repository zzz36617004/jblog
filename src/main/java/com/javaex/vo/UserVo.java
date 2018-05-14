package com.javaex.vo;

import java.sql.Date;

public class UserVo {
	private int userNo;
	private String id;
	private String userName;
	private String password;
	private Date joinDate;
	private String agreeProv;
	
	public UserVo(int userNo, String id, String userName, String password, Date joinDate, String agreeProv) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
		this.agreeProv = agreeProv;
	}
	public UserVo(int userNo, String id, String userName, String password, Date joinDate) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
	}
	public UserVo(String id, String userName, String password, Date joinDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
	}
	public String getAgreeProv() {
		return agreeProv;
	}
	public void setAgreeProv(String agreeProv) {
		this.agreeProv = agreeProv;
	}
	public UserVo() {
		super();
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", id=" + id + ", userName=" + userName + ", password=" + password
				+ ", joinDate=" + joinDate + ", agreeProv=" + agreeProv + "]";
	}
}
