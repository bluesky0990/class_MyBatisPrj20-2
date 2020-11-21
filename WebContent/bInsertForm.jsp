<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<title>회원가입창</title>
</head>
<body> 
<div class="container">
	<h2>게시글 작성</h2> 
	<form method="post" action="insert.do" class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-4">
					제목 : <input type="text" name ="subject" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4">
					작성자 : <input type="text" name ="writer" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4">
					내용 : <textarea name ="content" class="form-control" rows="10" cols="50" maxlength="500"></textarea>
				</div>
			</div>
			<input type="submit" value="글작성">
			<input type="reset" value="다시입력">
			<input type="button" value="홈으로" onclick="location.href='index.action'">
			<br><br>
	</form>
</div>
</body>
</html>