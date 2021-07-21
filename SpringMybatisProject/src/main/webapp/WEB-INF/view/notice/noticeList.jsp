<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
	<%@include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${lists }" var="dto" varStatus="cnt"> <!--리스트 서비스에서name값을 가지고온다 -->
		<tr>
			<td>${cnt.count }</td>
			
			<td><a href="noticeDetail?noticeNo=${dto.noticeNo }">${dto.noticeSub }</a></td>
			<td>${dto.noticeDate }</td>
			<td>${dto.noticeCount }</td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan ="4">
			<%@ include file="../include/includePage.jsp" %>
		</td>
		</tr>
	</table>
	<a href="noticeForm">공지사항 등록</a>

</body>
</html>