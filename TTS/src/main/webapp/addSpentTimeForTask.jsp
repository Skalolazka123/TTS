<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='./css/styles.css' type='text/css' />
<title>Add new spent time for task</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id='content'>
		<fieldset>
			<legend>Add new spent time for task</legend>
			<form action='resultAddSpentTimeForTask' method='POST'>
				Task Name: <select name='task_name'>
					<c:forEach var="task" items="${taskList}">
						<option value='<c:out value="${task.id}" />'><c:out
								value="${task.taskName}" /></option>
					</c:forEach>
				</select> </br> Responsible person: <select name='resp_person'>
					<c:forEach var="respPerson" items="${respPersonList}">
						<option value='<c:out value="${respPerson.id}" />'><c:out
								value="${respPerson.personName}" /></option>
					</c:forEach>
				</select> </br> Enter spent time (in hours): <input required type='text'
					name='spent_time_hours'></br> Select date: <input required
					type='datetime-local' name='date'></br> <input type='submit'
					value='Submit' />
			</form>
		</fieldset>
	</div>
</body>
</html>