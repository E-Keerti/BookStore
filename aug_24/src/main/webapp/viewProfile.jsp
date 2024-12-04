<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="aug_24.BookBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=(String)request.getAttribute("name");
BookBean bb=(BookBean)application.getAttribute("bbean");
out.println("Welcome "+name+"<br>");
out.println("Book Deatails<br>"+bb.getBookCode()+"&nbsp;&nbsp&nbsp"+bb.getBookName()+"&nbsp;&nbsp&nbsp"+bb.getBookAuthor()+"&nbsp;&nbsp&nbsp"+bb.getBookPrice()+"&nbsp;&nbsp&nbsp"+bb.getBookQty());
%>
</body>
</html>