package com.biz4up.bizsalad.user;

public class UserVO {

	private int no;
	private String uid;
	private String upw;
	private String uname;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "UserVO [no=" + no + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + "]";
	}

}
