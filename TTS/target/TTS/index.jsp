<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<title>First page</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div id = "content">
<fieldset>
<legend>First page</legend>
<ul>
  <li><a href="projects">Projects list</a> </li>
</ul>
<ul>
  <li><a href="allTasks">Tasks list</a> </li>
</ul>
<ul>
  <li><a href="addNewProject">Create new project</a> </li>
</ul>
</fieldset>
</div>
</body>
</html>