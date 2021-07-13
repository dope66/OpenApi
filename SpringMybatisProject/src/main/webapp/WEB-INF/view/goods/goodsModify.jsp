<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="goodsUpdate" method="post" name="frm"
		modelAttribute="goodsCommand" enctype="multipart/form-data">
		<input type="hidden" name="prodNum" value="${goodsCommand.prodNum }">
		<input type="hidden" name="prodName" value="${goodsCommand.prodName }">
		<table border=1 align="center">
			<tr>
				<th>상품 번호</th>
				<td>카테고리 : <select name="ctgr">
						<option value="wear"
							<c:if test="${goodsCommand.ctgr=='wear' }">selected</c:if>>
							의류</option>
						<option value="cosmetic"
							<c:if test="${goodsCommand.ctgr=='cosmetic' }">selected</c:if>>화장품</option>
						<option value="food"
							<c:if test="${goodsCommand.ctgr=='food' }">selected</c:if>>음식</option>
						<option value="car"
							<c:if test="${goodsCommand.ctgr=='car' }">selected</c:if>>차</option>


				</select>-상품번호 : ${goodsCommand.prodNum }
				</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="prodName"
					value="${goodsCommand.prodName }" /></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="number" min="10" step="10" name="prodPrice"
					value="${goodsCommand.prodPrice }" /> <form:errors
						path="prodPrice" /></td>
			</tr>
			<tr>
				<th>용량</th>
				<td><input type="number" min="10" name="prodCapacity"
					value="${goodsCommand.prodCapacity }" /> <form:errors
						path="prodCapacity" /></td>
			</tr>
			<tr>
				<th>공급처</th>
				<td><input type="text" name="prodSupplyer"
					value="${goodsCommand.prodSupplyer }" /> <form:errors
						path="prodSupplyer" /></td>
			</tr>

			<tr>
				<th>배송비</th>
				<td><input type="number" name="prodDelFee" min="0" step="100"
					value="0" /> <form:errors path="prodDelFee" /></td>
			</tr>
			<tr>
				<th>추천여부</th>
				<td><input type="radio" name="recommend" value="Y"
					<c:if test="${goodsCommand.recommend.trim() == 'Y' }">checked</c:if> />추천
					<input type="radio" name="recommend" value="N"
					<c:if test="${goodsCommand.recommend.trim() == 'N' }">checked</c:if> />비추
				</td>
			</tr>


			<tr>
				<th>내용</th>
				<td><textarea rows="6" cols="50" name="prodDetail">${goodsCommand.prodDetail}</textarea>
					<form:errors path="prodDetail"/></td>
			</tr>
			<tr>
				<td colspan="2">
				<c:forTokens items="${goodsCommand.prodImage }"
						delims="," var="prodImage">
						<p>
						<span id="fileName">${prodImage }</span>
					<input type="button" id="btn" value="삭제"
					onclick="fileDel(this)"/>
					</p>
					
					</c:forTokens></td>
			</tr>
			
			<tr><td colspan="2">
		<input type="file" name="prodImage" multiple="multiple"/>
			
			</td></tr>
			<tr>
				<th colspan="2"><input type="submit" value="상품 수정" /> <input
					type="button" value="취소" onclick="javascript:history.back();" /> <input
					type="button" value="삭제"
					onclick="javascript:location.href='goodsDel?prodNum=${goodsCommand.prodNum }';" />
					<input type="button" value="홈으로"
					onclick="javascript:location.href='main'" /></th>
			</tr>
		</table>
	<input type="hidden" name="fileDel1" id="fileDel1" />
	</form:form>


<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
	function fileDel(btn){
		var delFile = $("#fileDel1").val()
		if($(btn).attr("value") == "삭제"){
			$(btn).attr("value","삭제취소");
			$("#fileDel1").val(
					$(btn).parent().children("#fileName").text().trim()+","+delFile);
		}else{
			$(btn).attr("value","삭제");
			fileName=($(btn).parent().children("#fileName").text().trim()+",");
			$("#fileDel1").val(delFile.replace(fileName,""));
		}
		
	}
	
	

</script>


</body>
</html>