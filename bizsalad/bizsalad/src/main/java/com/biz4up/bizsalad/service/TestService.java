package com.biz4up.bizsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz4up.bizsalad.admin.AdminVO2;
import com.biz4up.bizsalad.mapper.TestMapper;

@Service
public class TestService {
	
	@Autowired
	public TestMapper mapper;
	
	public List<AdminVO2> selected() {
		return mapper.selectTest();
	}
}
