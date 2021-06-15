package com.biz4up.bizsalad.admin;

import java.sql.Date;

public class AdminVO {
	private int no;
	private String name;
	private String txt;
	private Date date;
	
	public AdminVO() {
		
	}
	
	public AdminVO(int no, String name, String txt) {
		this.no = no;
		this.name = name;
		this.txt = txt;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	/*
	@Override
	public String toString() {
		return "MainVO [no=" + no + ", name=" + name + ", txt=" + txt + ", date=" + date + ", toString()="
				+ super.toString() + "]";
	}
	*/
	
	
}
