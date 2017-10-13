<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My first JSP</title>
</head>
<body>
	<%
		java.util.Date date = new java.util.Date();
	%>
	<h2>My first JSP after a long time! ${name}</h2>
	<h4>
		Current time :
		<%=date%></h4>
</body>
</html>