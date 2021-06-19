<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function outConfirm() {
		if (confirm("Are you sure? ")) {
			document.frm.submit();

		} else {
		return false;
		}

	}
</script>
</head>
<body>
	<form action="empOutOk.mem" method="post" onsubmit="return outConfirm()" name="frm">
		비밀번호 : <input type="password" name="memPw" />
		<span>${pwFail }</span></br>
		<input type="submit"
			value="탈퇴" />

	</form>
</body>
</html>