package com.biz4up.bizsalad.persistence;

import java.util.List;

import com.biz4up.bizsalad.UserVO;

public interface UserDAO {
	public UserVO login(String uid) throws Exception;
	public void insert(UserVO vo) throws Exception;
	public List<UserVO> list()throws Exception;
}
