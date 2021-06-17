package com.biz4up.bizsalad;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.biz4up.bizsalad.persistence.OrderDAO;
import com.biz4up.bizsalad.persistence.UserDAO;

@SpringBootTest
class BizsaladApplicationTests {

	@Autowired
	OrderDAO dao;
	
	@Test
	void list()throws Exception {
		Criteria cri=new Criteria();
		System.out.println(dao.list(cri));
	}

}
