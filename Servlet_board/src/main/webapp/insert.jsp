<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="controller.do" method="post">
		<input type="hidden" name="command" value="bdinsert">

		<table border="1">
			<tr>
				<th>Name</th>
				<td><input type="text" name="sevname"></td>
			</tr>
			<tr>
				<th>Title</th>
				<td><input type="text" name="sevtitle"></td>
			</tr>
			<tr>
				<th>Content</th>
				<td><textarea rows="10" cols="60" name="sevcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="입력">
					<input type="button" value="취소"
					onclick="location.href='controller.do?command=main'"></td>
			</tr>
		</table>
	</form>
</body>
</html>