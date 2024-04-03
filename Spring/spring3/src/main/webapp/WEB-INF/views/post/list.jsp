<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
<div class="container">
  <h1>게시글 목록</h1>
  <table class="table">
    <thead>
      <tr>
      	<th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${list}" var="board">
			<tr>
				<td>${board.bo_num }</td>
				<td>
					<a href="#">${board.bo_title }</a>
				</td>
				<td>
					<a href="#">${board.bo_me_id }</a>
				</td>
				<td>${board.bo_view }</td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>