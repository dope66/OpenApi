<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${memId ==null }">입력하신 정보가 부족하여 아이디를 찾지 못했습니다.</c:if>
<c:if test="${memId !=null }"> 당신의 아이디는 ${memId }입니다</c:if>


<a href="../">main</a>
</body>
</html>