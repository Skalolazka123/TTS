<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='./css/styles.css' type='text/css' />
<title>Add new task</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id='content'>
		<fieldset>
			<legend>Add new task</legend>
			<form action='resultAddNewTask' method='POST'>
				Name: <input type='text' name='task_name'></br> 
				Project name: <select name='project_name'>
                    <c:forEach var="project" items="${projectList}">
                        <option value='<c:out value="${project.id}" />'><c:out
                                value="${project.projectName}" /></option>
                    </c:forEach>
                </select> </br> 
				Responsible person: <select name='resp_person'>
					<c:forEach var="respPerson" items="${respPersonList}">
						<option value='<c:out value="${respPerson.id}" />'><c:out
								value="${respPerson.personName}" /></option>
					</c:forEach>
				</select> </br> 
				<input type='submit' value='Submit' />
			</form>
		</fieldset>
	</div>
</body>
</html>