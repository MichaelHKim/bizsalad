package com.biz4up.bizsalad.api.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAPI2 {
	
	//Spring 4.0 이상은 @Controller 와 @ResponseBody 어노테이션을 추가하는 대신 @RestController 를 제공한다.
	
	@RequestMapping(value="/valueTest2", method = RequestMethod.GET)
	public String getValueTest2() {
		String valueTest = "RestController Test";
		
		return valueTest;
	}

}
