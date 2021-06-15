package com.biz4up.bizsalad.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyController {
	
    @RequestMapping(value="/company")
    public String home() {
        return "company";
    }
}
