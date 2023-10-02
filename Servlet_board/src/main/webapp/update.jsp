<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="controller.do" method="post">
		<input type="hidden" name="command" value="bdupdate"> <input
			type="hidden" name="bd_no" value="${dto.bd_no }">
		<table border="1">
			<tr>
				<th>Name</th>
				<td>${dto.bd_name }</td>
			</tr>
			<tr>
				<th>Title</th>
				<td><input type="text" name="sevtitle" value=${dto.bd_title }></td>
			</tr>
			<tr>
				<th>Content</th>
				<td><textarea rows="10" cols="60" name="sevcontent">${dto.bd_content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="location.href='controller.do?command=main'"></td>
			</tr>




		</table>
	</form>
</body>
</html>