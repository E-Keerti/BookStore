<%@page import="aug_24.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="aug_24.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
out.println(msg+"<br>");

AdminBean ab=(AdminBean)application.getAttribute("abean");
out.println("Welcome User :"+ab.getAdminName()+"<br>");
%>
<a href="addBook.html">ADD BOOK?</a><br>
<a href="deleteBook.html">DELETE BOOK?</a><br>
<a href="updateBook.html">UPDATE BOOK?</a><br>
<a href="viewBook.html">VIEW BOOK BY Code</a><br>
<a href="viewall">VIEWALL BOOK</a>
</body>
</html>