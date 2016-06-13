<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='./css/styles.css' type='text/css' />
<title>Add new project</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id='content'>
		<fieldset>
			<legend>Add new project</legend>
			<c:if test="${result == 1}">
				<p>Record created successfully</p>
			</c:if>
			<c:if test="${result == 0}">
				<p>An error occurred while creating record</p>
			</c:if>
		</fieldset>
	</div>
</body>
</html>