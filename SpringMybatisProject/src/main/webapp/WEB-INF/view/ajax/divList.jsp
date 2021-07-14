<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <c:if test="${n==1}">
	<div id="op1">
		<table>
			<tr>
				<th>연령</th>
				<th>제목</th>
				<th>학력</th>
				<th>경력</th>
			</tr>
			<tr>
				<th>A</th>
				<th>A</th>
				<th>A</th>
				<th>A</th>
			</tr>


		</table>
	</div>
	</c:if>
	<c:if test="${n==2}">
			<div id="op2">
		<table>
			<tr>
			<th>연령</th>
				<th>제목</th>
				<th>학력</th>
				<th>경력</th>
			</tr>
			<tr>
				<th>B</th>
				<th>B</th>
				<th>B</th>
				<th>B</th>
			</tr>


		</table>
	</div>
	</c:if>
	<c:if test="${n==3}">
			<div id="op3" >
		<table>
			<tr>
				<th>연령</th>
				<th>제목</th>
				<th>학력</th>
				<th>경력</th>
			</tr>
			<tr>
				<th>C</th>
				<th>C</th>
				<th>C</th>
				<th>C</th>
			</tr>


		</table>
	</div>
		</c:if>