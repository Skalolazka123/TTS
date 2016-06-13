<%@ page language="java" isErrorPage="true" contentType="text/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<title>Error page</title>
</head>
<body>

<%@ include file="header.jsp"%>
<div id = "content">
<p class="errorMessage">
<%=exception.getMessage()%>
</p>
<p id="error_img">
<img id="error_img" src="https://secure.qinec.com/Content/img/OhNo.png" height="500px">
</p>
</div>
</body>
</html>
