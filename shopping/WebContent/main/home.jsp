<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <link href="style.css" rel="stylesheet" type="text/css">



<style type="text/css"> 


a{ text-decoration:none }
a {
  color:blue;
  -o-transition:.5s;
  -ms-transition:.5s;
  -moz-transition:.5s;
  -webkit-transition:.5s;
  transition:.5s;
}
a:hover { color:red; }
.loginimg:hover{ }

</style>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인 안되었을 때  -->
	<c:if test="${empty authInfo }">
		<form action="login.sm" method="get" name="frm">
			<table border=1 class="tb">
				<tr>
					<td colspan="3">
					<input type="checkbox" name="idStore" value="store" <c:if test="${isId !=null }">checked</c:if>/>아이디저장 | 
					<input type="checkbox" name="autologin" value="auto" >
					자동로그인</td>
				</tr>
				
				<tr>
					<td >아이디</td>
					<td><input type="text" name="userId" value="${isId }"/><span>${userFail }</span></td>
					<td rowspan="2" class="loginimg"><input type="image" src="images/img1.jpg"
						width="60" alt="login" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="userPw" /><span>${pwFail }</span></td>
				</tr>
				<tr>
					<td colspan="3"><a href="idSearch.mem">아이디</a>/<a href="#">비밀번호 찾기</a> |
						<a href="memAgree.mem">회원가입</a></td>
				</tr>
			</table>
		</form>
	</c:if>
	<c:if test="${!empty authInfo }">

		<!-- 로그인 되었을 때 -->
		<c:if test="${authInfo.grade == 1 }">
			<!-- 일반 회원 -->
			<a href="myPage.mem">마이페이지</a>|
			<a href="goodsCartList.gd">장바구니</a>
			<a href="purchaseCon.gd">주문확인</a>
		</c:if>
		<c:if test="${authInfo.grade != 1 }">
			<a href="empMyPage.em">마이페이지 </a>|
			<!-- 직원 -->
			<a href="goodsList.gd">상품등록</a>
			<a href="#">공지사항</a>
			<!-- 관리자 -->
			<a href="empList.em">직원 리스트</a>|
			<a href="memList.mem">회원 리스트</a>|
			<a href="venta.vnt">판매현황</a>|
					</c:if>
		<a href="logout.sm">로그아웃</a>


	</c:if>
	<hr />
	<!--goods list -->
	<script>
	function goodsBuy(prodNum){
		if(${authInfo == null }){
			alert("please login ");
			return false;
		}else{
			
			location.href='prodInfo.gd?prodNum='+prodNum;
				
		}
		
		
	}
	
	</script>
	<table align="center" class="ta">
		<tr>
			<c:forEach items="${lists }" var="dto" varStatus="cnt">
				<td><a href="javascript:goodsBuy('${dto.prodNum }')"> <img
						width="200" height="200"
						src="goods/upload/${dto.prodImage.split(',')[0] } "></br>
						${dto.prodName }</br> 가격 : <fmt:formatNumber value="${dto.prodPrice }"
							type="currency" /></a></td>
				<c:if test="${cnt.count%3==0 }">
		</tr>
		<tr>
			</c:if>

			</c:forEach>
		</tr>
	</table>

</body>
</html>