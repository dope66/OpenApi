<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="noticeWrite" method="post">
title :<input type="text" name="noticeSub"/> <br/>
content : <textarea rows="5" cols="60" name="noticeCon"></textarea> <br/>
type  : <select  name="noticeKind">
		<option>emergency</option>
		<option>normal</option>
		<option>check</option>
		
		</select> <br/>
<input type="submit" value="submit">



</form>
</body>
</html>