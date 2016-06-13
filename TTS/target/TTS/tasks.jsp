<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<title>List of tasks</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div id = 'content'>
<fieldset>
<legend>List of tasks:</legend>
<c:forEach var="task" items="${tasksList}">
    <p>Task name: 
    <a href='task?id=<c:out value="${task.id}" />&name=<c:out value="${task.taskName}" />'><c:out value="${task.taskName}" /></a>
</p>
</c:forEach>
<p><a href='addNewTask'>Create new task</a><p>
</fieldset>
</div>
</body>
</html>