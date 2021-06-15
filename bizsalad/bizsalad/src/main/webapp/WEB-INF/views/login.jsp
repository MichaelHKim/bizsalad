<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!--  로그인 Form -->
    <div class="panel panel-primary" style="width:400px; margin:0px auto;">
        <div class="panel-heading"><h3 class="panel-title" style="text-align:left;">로그인</h3></div>
        <div class="panel-body">
            <form id="login-form" name="frm">
                <div style="margin-bottom:10px;">
                    <input type="text" name="uid" class="form-control" placeholder="아이디 입력"/>
                </div>
                <div style="margin-bottom:10px;">
                    <input type="password" name="upw" class="form-control" placeholder="비밀번호 입력"/>
                </div>
                 <div style="margin-bottom:10px;">
                    <span><input type="checkbox" name="chkLogin">로그인 상태유지</span>
                    <span style="float:right;"><a href="insert"> 회원가입 </a></span>
                </div>
                <div>
                    <button type="submit" class="form-control btn btn-primary">로그인</button>
                 </div>
            </form>
        </div>
    </div>
<script>
   $(frm).on("submit", function(e){
      e.preventDefault();
      var chkLogin = $(frm.chkLogin).is(":checked")?"true":"false";
      //alert(chkLogin);
      
      var uid = $(frm.uid).val();
      var upw = $(frm.upw).val();
   
      if(uid==""||upw==""){
         alert("아이디와 비밀번호를 입력하세요!");
         return;
      }      
      
      
      $.ajax({
         type:"post",
         url:"login",
         data:{"uid":uid, "chkLogin":chkLogin, "upw":upw},
         success:function(data){            
            if(data.result == 0){
               alert("아이디가 존재하지 않습니다!");
            }else if(data.result == 1){
               alert("로그인 성공")
               //alert(data.path);
               location.href=data.path;
            }else{
               alert("비밀번호가 일치하지 않습니다!");
            }
         }
      });
   });
</script>