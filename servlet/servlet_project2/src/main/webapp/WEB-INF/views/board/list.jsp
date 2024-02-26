<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<!-- 서버에서 보낸 데이터를 c:forEach를 이용하여 화면에 출력 -->
	<h1>게시글 리스트</h1>
  	<table class="table table-hover">
	    <thead>
	      	<tr>
	       		<th>번호</th>
	       		<th>게시판</th>
	       		<th>제목</th>
	        	<th>작성자</th>
	        	<th>조회수</th>
	      	</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${list}" var="board">
		      	<tr>
			        <td>${board.bo_num}</td>
			        <td>${board.bo_co_num}</td>
			        <td>
			        	<a href="">${board.bo_title}</a>
			        </td>
			        <td>
			        	<a href="">${board.bo_me_id}</a>
			        </td>
			        <td>${board.bo_view}</td>
		      	</tr>
	      	</c:forEach>
	    </tbody>
  	</table>
</div>
</body>
</html>