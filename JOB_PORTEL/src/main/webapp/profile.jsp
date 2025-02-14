<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="JavaBeans.*,profile.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	User u=(User)request.getAttribute("u");
	out.println(u.getName());
	%>
</body>
</html>