package com.biz4up.bizsalad.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biz4up.bizsalad.service.TestService;

@Controller
public class MapperController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/mapper")
	public ModelAndView test() throws Exception {
		ModelAndView mav = new ModelAndView("mapper");
		
		List<AdminVO2> testList = testService.selected();
		mav.addObject("list", testList);
		
		return mav;
	}
}
