<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='./css/styles.css' type='text/css' />
<title>Reporting about spent time for date</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id='content'>
		<fieldset>
			<legend>Reporting about spent time for date range</legend>
			<h3>First report</h3>
			<p>Which entries have been made for a given date range?</p>
			<ul class="list_with_decoration">
				<c:forEach var="spentTime" items="${spentTimeList}">
					<li>Date: <c:out value="${spentTime.date}" /> , spent time: <c:out
							value="${spentTime.hours}" /> hours , responsible person: <c:out
							value="${spentTime.respPerson}" /> , task name: <c:out
							value="${spentTime.task}" />
					</li>
				</c:forEach>
			</ul>
			<h3>Second report</h3>
			<p>How much hours committed each person in a given date range?</p>

			<ul class="list_with_decoration">
				<c:forEach var="spentTimeForPerson"
					items="${spentTimeForPersonList}">
					<li>Responsible person: <c:out
							value="${spentTimeForPerson.respPerson}" /> , all spent time for
						a given date range: <c:out value="${spentTimeForPerson.hours}" /> hours
					</li>
				</c:forEach>
			</ul>
		</fieldset>
	</div>
</body>
</html>