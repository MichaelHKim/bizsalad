package com.biz4up.bizsalad;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz4up.bizsalad.UserVO;
import com.biz4up.bizsalad.persistence.UserDAO;

import ch.qos.logback.classic.Logger;


@Controller
public class MainController {
	
	
	@Autowired
	UserDAO dao;
	/*
	@Autowired
	BCryptPasswordEncoder passEncoder;
	*/
    @RequestMapping(value="/")
    public String main() {
   	
        return "index";
    }

    @RequestMapping(value="/login")
    public String login() {
   	
        return "login";
    }
    
    
	 @RequestMapping(value="login",method=RequestMethod.POST)
	   @ResponseBody
	   public HashMap<String,Object> loginPost(String uid, String upw, HttpSession session,
	                  boolean chkLogin,HttpServletResponse response) throws Exception{
		 
		 
	      
	      HashMap<String,Object> map = new HashMap<>();
	      
	      int result = 0; //아이디가 존재하지 않는 경우
	      UserVO vo = dao.login(uid);
	      
	      //System.out.print(vo.getUpw());
	      
	      if(vo!=null){ //아이디 유무 여부 체크
	    	  //if(passEncoder.matches(upw, vo.getUpw())){
	    	  if(upw.equals(vo.getUpw())){
		    	  System.out.println("로그인 성공...");
		    	  result = 1; //로그인 성공
		    	  if(chkLogin){
		 	         //쿠키에는 스트링 값을!
		 	         Cookie cookie = new Cookie("uid",vo.getUid());
		 	         cookie.setPath("/");
		 	         //언제까지 저장할지 초단위로!
		 	         cookie.setMaxAge(60*60*24*7); //7일간보관
		 	         response.addCookie(cookie); //저장완료!
		 	      }
		 	      //로그인 성공했을때! ->메뉴에서uid로 체크하기때문에!!
		 	      session.setAttribute("member", vo.getUid());
		 	      String path = (String)session.getAttribute("path");
		 	      if(path==null) path="/";	 	
		 	      map.put("path", path);		 	    
		      }else{
		    	  //System.out.println("비밀번호 불일치...");
		    	  result = 2; //비밀번호 불일치
		      }
	      }
	      map.put("result", result);
	   
	      return map;
	   }
    
    
}