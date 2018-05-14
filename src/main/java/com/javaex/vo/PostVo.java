package com.javaex.vo;

import java.sql.Date;

public class PostVo {
	private int postNo;
	private int cateNo;
	private String postTitle;
	private String postContent;
	private Date regDate;
	
	public PostVo(int cateNo, String postTitle, String postContent) {
		super();
		this.cateNo = cateNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
	}
	public PostVo(int postNo, int cateNo, String postTitle, String postContent, Date regDate) {
		super();
		this.postNo = postNo;
		this.cateNo = cateNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.regDate = regDate;
	}
	public PostVo() {
		super();
	}
	public PostVo(int cateNo, String postTitle, String postContent, Date regDate) {
		super();
		this.cateNo = cateNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.regDate = regDate;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "PostVo [postNo=" + postNo + ", cateNo=" + cateNo + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", regDate=" + regDate + "]";
	}
	
}
