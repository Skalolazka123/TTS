<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
<title>List of tasks</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id='content'>
		<fieldset>
			<legend>
				Task name: "
				<c:out value="${taskName}" />
				"
			</legend>
			<p>
				Task name:
				<c:out value="${taskName}" />
			</p>
			<c:forEach var="task" items="${task}">
				<p>
					Responsible person:
					<c:out value="${task.respPerson}" />
					, Spent Time
					<c:out value="${task.hours}" />
				</p>
			</c:forEach>

			<p>
				<a href='spentTimeForTask'>Add Spent time for this task</a>
			<p>
		</fieldset>
	</div>
</body>
</html>