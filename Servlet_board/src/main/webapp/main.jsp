<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<h1> 게시판 목록 </h1>
		<table border="1">
			<col width="50px">
			<col width="100px">
			<col width="200px">
			<col width="100px">
			<col width="50px">
			<col width="50px">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Title</th>
				<th>Date</th>
				<th>update</th>
				<th>delete</th>
			</tr>
			
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.bd_no }</td>
				<td>${dto.bd_name }</td>
				<td><a href="controller.do?command=one&bd_no=${dto.bd_no }"> ${dto.bd_title }</a></td>
				<td>${dto.bd_date }</td>
				<td><a href="controller.do?command=update&bd_no=${dto.bd_no}">수정</a></td>
				<td><a href="controller.do?command=delete&bd_no=${dto.bd_no}">삭제</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
					<input type="button" value="글쓰기" onclick="location.href='controller.do?command=insert'">
				</td>
			</tr>
	
		</table>

</body>
</html>