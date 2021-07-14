<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	fucntion testDiv(num){
		if(num=1){
	op1.style.display="";
	op2.style.display="none";
	op3.style.display="none";

		}else if(num==2){
			op1.style.display="none";
			op2.style.display="";
			op3.style.display="none";

			
		}else if(num==3){
			op1.style.display="none";
			op2.style.display="none";
			op3.style.display="";
		}
		
		
	}
	
</script>
</head>
<body>

		<ul>
			<li onclick="testDiv(1)">경력3년이상</li>
			<li onclick="testDiv(2)">석박사</li>
			<li onclick="testDiv(3)">it개발자</li>
		</ul>
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
			<div id="op2" style="display:none">
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
			<div id="op3" style="display:none">
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
</body>
</html>