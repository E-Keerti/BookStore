<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="aug_24.BookBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=(String)request.getAttribute("name");
out.println("Welcome "+name+"<br>");
List<BookBean> list=(ArrayList<BookBean>)request.getAttribute("listofbooks"); 

if(list!=null)
{
	for(BookBean b:list)
	{
     out.println("<br>"+b.getBookCode()+"&nbsp;&nbsp&nbsp"+b.getBookName()+"&nbsp;&nbsp&nbsp"+b.getBookAuthor()+"&nbsp;&nbsp&nbsp"+b.getBookPrice()+"&nbsp;&nbsp&nbsp"+b.getBookQty()+"<br>");
	}
}
else
{
	out.println("Error");
}
%>
</body>
</html>