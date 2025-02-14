<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,jobsOpration.*,recruterBean.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/allJobs.css">
</head>
<body>
<div class="container">
    <h2 style="text-align: center;">My Posted Jobs</h2>
    <div class="job-container">
        <%
        List<JobPost> myjobs = (List<JobPost>) request.getAttribute("myjobs");
        for (JobPost j : myjobs) {
            String jobid = j.getJobId();
            String recId = j.getRecruterId();
        %>
        <div class="card">
            <div class="card__hero">
                <h2 class="card__job-title"><%= j.getTitle() %></h2>
                <p><strong>Company:</strong> <%= j.getCompanyName() %></p>
                <p><strong>Location:</strong> <%= j.getLocation() %></p>
                <p><strong>Salary:</strong> $<%= j.getSalary() %></p>
            </div>
            <div class="card__footer">
                <form method="post" action="deleteJob">
                    <input type="hidden" name="rid" value="<%= recId %>">
                    <input type="hidden" name="jid" value="<%= jobid %>">
                    <button type="submit" class="card__btn">Delete Job</button>
                </form>
            </div>
        </div>
        <%
        }
        %>
    </div>
</div>

</body>
</html>