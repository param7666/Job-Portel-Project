<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,recruterBean.*,jobsOpration.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	JobPost j=(JobPost) request.getAttribute("myjobs");
	
		String jobid=j.getJobId();
		String recId=j.getRecruterId();
		out.println(j.getCompanyName());
		out.println(j.getTitle());
		out.println(j.getSalary());
		out.println(j.getRole());
		out.println(j.getEmpType());
		out.println(j.getCatagory());
		out.println(j.getLocation());
		out.println(j.getExperince());
		out.println(j.getSkill());
		out.println(j.getResponsibility());
		
	%>
</body>
</html>