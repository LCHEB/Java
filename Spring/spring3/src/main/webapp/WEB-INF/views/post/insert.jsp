<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<div class="container">
	<h1 class="title">게시글 작성</h1>
  <form action="<c:url value="/post/insert"/>" method="post" enctype="multipart/form-data">
  	<div class="form-group">
    	<label for="community">게시판</label>
		<select name="bo_co_num" class="form-control" id="community">
			<c:forEach items="${list}" var="co">
				<option value="${co.co_num}">${co.co_name}</option>
			</c:forEach>
		</select>
    </div>
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" name="bo_title">
    </div>
    <div class="form-group">
      <label for="content">내용:</label>
      <textarea  class="form-control" id="content" name="bo_content"></textarea>
    </div>
    <div class="form-group">
		<label>파일</label>
		<input type="file" class="form-control" name="files"/>
	</div>
    <button type="submit" class="btn btn-primary col-12">작성</button>
  </form>
  
</div>
</body>
</html>