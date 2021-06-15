package com.biz4up.bizsalad.persistence;

import com.biz4up.bizsalad.UserVO;

public interface UserDAO {
	public UserVO login(String uid) throws Exception;
	public void insert(UserVO vo) throws Exception;
}
