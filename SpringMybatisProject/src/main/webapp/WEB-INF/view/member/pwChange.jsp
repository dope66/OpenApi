<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="pwChangeOk" name="frm" method="post">
비밀 번호 : <form:password path="memPw"/>
<form:errors path="memPw"/>
</br>

<input type="submit" value="확인"/>

</form:form>
</body>
</html>