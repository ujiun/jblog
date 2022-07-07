package com.javaex.vo;

public class CategoryVo {
	
	//필드
	private int cateNo;
	private String id;
	private String cateName;
	private String desctiption;
	private String regDate;
	
	
	//생성자
	public CategoryVo() {
	}


	public CategoryVo(int cateNo, String id, String cateName, String desctiption, String regDate) {
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.desctiption = desctiption;
		this.regDate = regDate;
	}

	
	//메소드-gs
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


	public String getDesctiption() {
		return desctiption;
	}


	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	//메소드-일반
	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", desctiption=" + desctiption
				+ ", regDate=" + regDate + "]";
	}
	
}
