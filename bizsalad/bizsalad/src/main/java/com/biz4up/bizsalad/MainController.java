package com.biz4up.bizsalad;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.biz4up.bizsalad.persistence.UserDAO;
import com.biz4up.bizsalad.user.UserVO;


@Controller
public class MainController {
   
   @Autowired
   UserDAO dao;

   
    @RequestMapping(value="/")
    public String main() {
        return "index";
    }
    
    @RequestMapping(value="/login")
    public String login(Model model) {
       model.addAttribute("pageName", "/login.jsp");
        return "login";
    }
    
    @RequestMapping(value="login",method=RequestMethod.POST)
      @ResponseBody
      public HashMap<String,Object> loginPost(String uid, String upw, HttpSession session,
                     boolean chkLogin,HttpServletResponse response) throws Exception{
         
         HashMap<String,Object> map = new HashMap<>();
         
         int result = 0; //아이디가 존재하지 않는 경우
         UserVO vo = dao.login(uid);
         
         if(vo!=null){ //아이디 유무 여부 체크
            if(vo.getUpw().equals(upw)){
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
                session.setAttribute("uid", vo.getUid());
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
    
    
    @RequestMapping("logout")
      public String logout(Model model,HttpSession session,
               HttpServletResponse response,HttpServletRequest request){
         
         model.addAttribute("pageName", "index.jsp");
         session.invalidate(); //세션 정보 지우기
         
         //쿠키 삭제
         Cookie cookie = WebUtils.getCookie(request, "uid");
         if(cookie != null){
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
         }
         return "/index";
      }
}