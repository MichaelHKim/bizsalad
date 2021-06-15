package com.biz4up.bizsalad.persistence;


import com.biz4up.bizsalad.user.UserVO;

public interface UserDAO {

	public UserVO login(String uid) throws Exception;
	
}
