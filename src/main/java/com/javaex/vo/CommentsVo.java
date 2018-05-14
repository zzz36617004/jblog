package com.javaex.vo;

import java.sql.Date;

public class CommentsVo {
	private String userName;
	private int cmtNo;
	private int postNo;
	private int userNo;
	private String cmtContent;
	private Date regDate;
	public CommentsVo(String userName, int postNo, int userNo, String cmtContent) {
		super();
		this.userName = userName;
		this.postNo = postNo;
		this.userNo = userNo;
		this.cmtContent = cmtContent;
	}
	
	public CommentsVo() {
		super();
	}

	public CommentsVo(String userName, int cmtNo, int postNo, int userNo, String cmtContent, Date regDate) {
		super();
		this.userName = userName;
		this.cmtNo = cmtNo;
		this.postNo = postNo;
		this.userNo = userNo;
		this.cmtContent = cmtContent;
		this.regDate = regDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCmtNo() {
		return cmtNo;
	}
	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CommentsVo [userName=" + userName + ", cmtNo=" + cmtNo + ", postNo=" + postNo + ", userNo=" + userNo
				+ ", cmtContent=" + cmtContent + ", regDate=" + regDate + "]";
	}
	
}
