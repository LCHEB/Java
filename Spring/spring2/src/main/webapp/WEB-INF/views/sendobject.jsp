<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트</title>
</head>
<body>
	<form action="<c:url value="/send/object"/>" method="post">
		<label>아이디</label>
		<input type="text" name="list[0].id">
		<br>
		<label>비밀번호</label>
		<input type="password" name="list[0].pw">
		<br>
		<label>아이디</label>
		<input type="text" name="list[1].id">
		<br>
		<label>비밀번호</label>
		<input type="password" name="list[1].pw">
		<br>
		<label>아이디</label>
		<input type="text" name="list[2].id">
		<br>
		<label>비밀번호</label>
		<input type="password" name="list[2].pw">
		<br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>