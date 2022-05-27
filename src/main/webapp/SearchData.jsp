<%@page import="linkcode.bank.model.Account"%>
<%@page import="linkcode.bank.dao.AccountDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="SearchController">
	Account Number<input type="text" name="accno"><br/>
	<input type="submit" value="Search">
	</form>
	
<%! Account a=null; %>

<% 
if(!session.isNew())
{
a=(Account)session.getAttribute("data");
session.invalidate();

%>
<h1>Searched Data Is</h1>
<table>
	<tr><td>accno</td><td><%=a.getAccno() %></td>
	</tr>
	<tr><td>cname</td><td><%=a.getCname() %></td>
	</tr>
	<tr><td>uname</td><td><%=a.getUname() %></td>
	</tr>
	<tr><td>accball</td><td><%=a.getAccBall() %></td>
	</tr>
</table>
<%} %>
</body>

</html>