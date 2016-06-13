<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<title>List of projects</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div id = 'content'>
<fieldset>
<legend>List of projects:</legend>
<c:forEach var="project" items="${projectList}">
    <p>Project name: 
    <a href='project?id=<c:out value="${project.id}" />&name=<c:out value="${project.projectName}" />'><c:out value="${project.projectName}" /></a>
    <c:out value=", responsible person: ${project.respPerson}" />
</p>
</c:forEach>
<p><a href='addNewProject'>Create new project</a></p>
</fieldset>
</div>
</body>
</html>