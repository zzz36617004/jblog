package com.javaex.vo;

import java.sql.Date;

public class CategoryVo {
	private int cateNo;
	private String id;
	private String cateName;
	private int postNum;
	private String description;
	private Date regDate;
	

	public CategoryVo(int cateNo, String id, String cateName, int postNum, String description, Date regDate) {
		super();
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.postNum = postNum;
		this.description = description;
		this.regDate = regDate;
	}

	
	public CategoryVo(String id, String cateName, String description) {
		super();
		this.id = id;
		this.cateName = cateName;
		this.description = description;
	
	}

	public CategoryVo(int cateNo, String id, String cateName, String description, Date regDate) {
		super();
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}
	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public CategoryVo() {
		super();
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", descriptorin="
				+ description + ", regDate=" + regDate + "]";
	}
	
	
}
