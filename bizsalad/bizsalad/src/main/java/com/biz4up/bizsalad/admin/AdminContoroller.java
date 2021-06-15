package com.biz4up.bizsalad.admin;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminContoroller {
	
    @RequestMapping(value="/admin")
    public String admin(AdminVO avo, Model model) {
    	
    	avo = new AdminVO(1,"홍길동","텍스트");
    	model.addAttribute("avo", avo);
    	
        return "admin";
    }
    
    
    @RequestMapping("/test")
    public ModelAndView test() throws Exception { 
    	ModelAndView mav = new ModelAndView("test"); 
    	mav.addObject("name", "비즈샐러드");
    	List<String> testList = new ArrayList<String>();
    	testList.add("a");
    	testList.add("b");
    	testList.add("c");
    	mav.addObject("list", testList);
    	return mav; 
    }

    
}
