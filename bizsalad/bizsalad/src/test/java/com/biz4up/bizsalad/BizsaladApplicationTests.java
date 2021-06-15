package com.biz4up.bizsalad;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.biz4up.bizsalad.domain.Criteria;
import com.biz4up.bizsalad.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class) 

@SpringBootTest
public class BizsaladApplicationTests {

	@Autowired
	private UserDAO dao;

	
}
