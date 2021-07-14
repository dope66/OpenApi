<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn3").click(function() {
			//$("#frm").submit(); //안된다면 동기식으로 테스트
			
			
			$("#frm").ajaxSubmit({
				type : "post",
				url : "ajaxTest1",
				datatype : "html",
				success : function(result) {//익명함수
					$("#notice_content").html(result);
				},
				error : function() {
					alert('마 에러다.');
					return;
				}
			});//$().ajaxSubmit 
		});///$().click
		$("#btn4").click(function() {
			//$("#frm").submit(); //안된다면 동기식으로 테스트
		 	var aaa ={
		 			type : "post",
					url : "ajaxTest1",
					datatype : "html",
					success : function(result) {
						$("#notice_content").html(result);
					},
					error : function() {
						alert('마 에러다.');
						return;
					}
		 		}
		 
		 	$("#frm").ajaxSubmit(aaa);
		});///$().click
		
		$("#btn5").click(function() {
			//$("#frm").submit(); //안된다면 동기식으로 테스트
		 	var aaa ={
		 			type : "post",
					url : "ajaxTest1",
					datatype : "html",
					beforeSubmit: beforeTest ,
					success : okTest , //성공되고나서 실행되는 함수 
					error : err
		 		}
		 	$("#frm").ajaxSubmit(aaa);
		});///$().click
		
	});//$(function)
	function beforeTest(){
		if($("#n").val()==""){
			alert("값을 입력");
			$("#n").focus();
			return false;
		}else{
			alert("ajax가 submit하기전에 실행되는 함수 ")
		}
	}
function okTest(responseText,statusText,xhr,$form){//ajax가반환하는 4개의 값임 
	if(statusText=="success"){
		$("#notice_content").html(responseText);
		$form.css('background','red');
	}
}
function err(){
	alert("삐-빅 에러");
	return false;
	
}

	function testDiv(num) {
		/*   location.href="ajaxTest1?n="+num  */// 직접 페이지 이동 동기식
		$.ajax({

			//jason 비동기식
			type : "post",
			url : "ajaxTest1",
			datatype : "html",
			data : "n=" + num,
			success : function(result) {
				$("#notice_content").html(result);
			},
			error : function() {
				alert('마 에러다.');
				return;

			}

		});
	}
</script>

</head>
<body>
	<ul>
		<li onclick="testDiv(1)">경력3년이상</li>
		<li onclick="testDiv(2)">석박사</li>
		<li onclick="testDiv(3)">it개발자</li>
	</ul>
	<div id="notice_content"></div>
	<form name="frm" id="frm" action="ajaxTest1">
		<input type="text" id="n" name="n">

	</form>
	<button id="btn3">버튼3</button>
	<button id="btn4">버튼4</button>
	<button id="btn5">버튼5</button>

</body>
</html>