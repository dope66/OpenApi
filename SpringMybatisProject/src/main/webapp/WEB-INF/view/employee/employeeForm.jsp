<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action ="empJoin" method="post" name="frm"
	modelAttribute="employeeCommand">
		<table border=1 align="center">
			<tr>
				<td>사원번호</td>
				<td><form:input path="employeeId"/><!--에러 /input저장위함  -->
				<form:errors path="employeeId"/>
				</td>
			</tr>
			<tr>
				<td>사원아이디</td>
				<td><form:input path="empUserId"/>
				<form:errors path="empUserId"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><form:password path="empPw"/>
				<form:errors path="empPw"/></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><form:password path="empPwCon"/>
				<form:errors path="empPwCon"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="empName"/>
				<form:errors path="empName"/></td>
			</tr>
			<tr>
				<td>입사일</td>
				<td><input type="date" name="hireDate" />
				<form:errors path="hireDate"/></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><form:input  path="phNumber" placeholder="010-1234-1234"/>
				<form:errors path="phNumber"/></td>
			</tr>
			<tr>
				<td>직무</td>
				<td><form:input path="jobId"/>
				<form:errors path="jobId"/></td>
			</tr>
			<tr>
				<td>사무실 번호</td>
				<td><form:input  path="officeNumber" placeholder="031-123-1234" />
				<form:errors path="officeNumber"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><form:input path="email"/>
				<form:errors path="email"/></td>
			</tr>
			<tr>
				<td>사무실 주소</td>
				<td><form:input path="empAddress"/>
				<form:errors path="empAddress"/></td>
			</tr>
			
			<tr>
			<td colspan="2">
			<input type="submit" value="등록" />
			</td>
			</tr>
		</table>
	</form:form>
</body>
</html>