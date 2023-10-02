<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
	<h1>게시글 보기</h1>
	<table border="1">
		<col width="50px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
		<col width="50px">

		<tr>
			<th>Name</th>
			<td>${dto.bd_name }</td>
		</tr>

		<tr>
			<th>Title</th>
			<td>${dto.bd_title }</td>
		</tr>
		<tr>
			<th>Content</th>
			<td><textarea rows="10" cols="60">${dto.bd_content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='controller.do?command=update&bd_no=${dto.bd_no}'">
				<input type="button" value="삭제" onclick="location.href='controller.do?command=delete&bd_no=${dto.bd_no}'">
				<input type="button" value="목록" onclick="location.href='controller.do?command=main'">
		</tr>




	</table>

</body>
</html>