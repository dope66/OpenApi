<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	pageContext.setAttribute("br", "\n");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>goodsDetail.jsp</title>
<script >
function onQty(){
	var qty=document.frm.PurchaseQty.value;
	document.getElementById("tot").innerHTML=qty*${dto.prodPrice}
}
function goodsCartAdd(prodNum){
	
	var qty=document.frm.PurchaseQty.value;
	location.href="goodsCartAdd.gd?prodNum="
			+prodNum+"&qty="+qty+"&prodPrice=${dto.prodPrice}";
	
}

</script>
</head>
<body>
<a href="prodModify?prodNum=${goodsCommand.prodNum } ">수정</a>
<form action="#" name="frm" method="post"

>
<input type="hidden" name="prodNum" value="${goodsCommand.prodNum }">
${goodsCommand.ctgr }의 ${goodsCommand.prodName } 상품 설명 입니다.
	<table width="800" align="center" border=1 >
		<tr>
			<td rowspan="6"><img height="300" width="500"
				src="goods/upload/${goodsCommand.prodImage.split(',')[0] }" /></td>
			<td>상품 이름 :${goodsCommand.prodName }</td>
		</tr>
		<tr>
			<td>
			상품 가격 : <fmt:formatNumber value="${goodsCommand.prodPrice }"
			 type="currency"
			></fmt:formatNumber>
			</td>
		</tr>
		<tr>
			<td align=left><c:if test="${goodsCommand.prodDelFee ==0 }">무료 배송</c:if>
				<c:if test="${goodsCommand.prodDelFee !=0 }">배송비 :${goodsCommand.prodDelFee }원</c:if>
			</td>
		</tr>
		<tr>
			<td>
			<input type="number" min="1" name="PurchaseQty"
			onchange="onQty();" value="1" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			${goodsCommand.prodPrice }
			
			</td>
		</tr>
		<tr>
			<td align="right">총상품금액 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span id="tot">${goodsCommand.prodPrice }</span>
			</td>
		</tr>
		<tr>
			<td><input type="button" value="장바구니" 
			onclick="goodsCartAdd('${goodsCommand.prodNum}'); "/>
				<input type="submit" value="바로구매" />
							
			</td>
		</tr>
		<tr>
			<td colspan="2">
			용량 : ${goodsCommand.prodCapacity }</br>
			공급 업체 : ${goodsCommand.prodSupplyer } </br>
			${goodsCommand.prodDetail }</br>
	<c:forTokens items="${goodsCommand.prodImage }" delims=","
	var="prodImage">
	<c:if test="${file !='null' }">
	<img width="800" src="../goods/upload/${prodImage }"/></br>
	</c:if>
	</c:forTokens>			
			</td>
		</tr>
	</table>
	</form>
	추천여부 : 
	<c:if test="${goodsCommand.recommend=='Y' }">추천
	</c:if>
	<c:if test="${goodsCommand.recommend=='N' }">비추천
	</c:if><br/>
	
	리뷰
	<hr/>
	<c:forEach items="${list }" var="dto">
	<p>
	<c:if test="${goodsCommand.memId ==null }">탈퇴한 사용자</c:if>
	<c:if test="${goodsCommand.memId !=null }">${goodsCommand.memId }</c:if>
	 / ${goodsCommand.reviewDate }<br/>
	<c:if test="${goodsCommand.reviewImg != null }">
	<img src="goods/review/${goodsCommand.reviewImg }"><br/>
	</c:if>
	
	${fn:replace(goodsCommand.reviewContent,br,"<br/>") }
	
	</p>
	<hr/>
	
	</c:forEach>
</body>
</html>