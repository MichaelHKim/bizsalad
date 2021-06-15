<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>View Test Page</title>
</head>
<body>
	<h2>${avo.getName()} 관리자님, 안녕하세요.</h2>
	<div>관리자번호 : ${avo.getNo()} / ${avo.getTxt()}</div>
	

</body>
</html>
