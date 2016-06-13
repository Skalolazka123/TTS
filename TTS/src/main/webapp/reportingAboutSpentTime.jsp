<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='./css/styles.css' type='text/css' />
<title>Reporting about spent time</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <div id='content'>
        <fieldset>
            <legend>Reporting about spent time</legend>
            <form action='resultReporting' method='POST'>
                <p>For this report select start date and end date</p>
                Select start date: <input required type='datetime-local' name='start_date'></br>
                Select end date: <input required type='datetime-local' name='end_date'></br>
                <input type='submit' value='Submit'/>
            </form>
        </fieldset>
    </div>
</body>
</html>