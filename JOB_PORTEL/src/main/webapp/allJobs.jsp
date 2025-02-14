<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,jobsOpration.*,recruterBean.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JobHunter - Jobs</title>
<link rel="stylesheet" href="css/allJobs.css">
</head>
<body>
	<nav>
    <div class="navbar">
        <div class="title">JobPortal</div>
        <form action="/search" method="GET" class="search_bar">
            <input id="searchInput" placeholder="Enter your text..." class="input" name="query" type="text" required>
            <button type="submit" class="search_btn">Search</button>
        </form>
        <div class="nav-links">
            <a href="#home">Engineering</a>
            <a href="#about">Teaching</a>
            <a href="#services">Government</a>
            <a href="#contact">Freelance</a>
        </div>
    </div>
</nav>
    
            
<div class="container">
    <h2 style="text-align: center;">Available Jobs</h2>
    <div class="job-container">
        <%
        List<JobPost> alljobList = (ArrayList<JobPost>) request.getAttribute("allJobs");
        for (JobPost j : alljobList) {
            String rid = j.getRecruterId();
            String jid = j.getJobId();
        %>
        <div class="card">
            <div class="card__hero">
                <h2 class="card__job-title"><%= j.getTitle() %></h2>
                <p><strong>Company:</strong> <%= j.getCompanyName() %></p>
                <p><strong>Location:</strong> <%= j.getLocation() %></p>
                <p><strong>Employment Type:</strong> <%= j.getEmpType() %></p>
                <p><strong>Salary:</strong> $<%= j.getSalary() %></p>
            </div>
            <div class="card__footer">
                <a href="jobDetails?rid=<%= rid %>&jid=<%= jid %>" class="card__btn">See Details</a>
                <button type="button" class="card__btn apply-btn" 
    				data-jid="<%= jid %>" 
    				data-rid="<%= rid %>">Apply Now
				</button>
            </div>
        </div>
        <%
        }
        %>
    </div>
</div>


</div>

<div id="applyJobModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2 style="text-align: center; color: #ff5900;">Apply for Job</h2>
        
        <form id="applyJobForm" action="applyForJob" method="post" enctype="multipart/form-data" class="form">
            <!-- Job ID and Recruiter ID will be set dynamically -->
            <input type="hidden" name="jid" id="jid">
            <input type="hidden" name="rid" id="rid">

            <input type="text" id="fullName" name="fullName" placeholder="Full Name" class="input" required>
            
            <input type="email" id="email" name="email" placeholder="Email" class="input" required>

            <input type="tel" id="phone" name="phone" placeholder="Phone Number" class="input" required>

            <textarea id="coverLetter" name="coverLetter" placeholder="Cover Letter (Optional)" class="textarea"></textarea>

            <label for="resume" style="color: #ff5900;">Upload Resume:</label>
            <input type="file" id="resume" name="resume" class="input" accept=".pdf" required>

            <button type="submit" class="button">Submit Application</button>
        </form>
    </div>
</div>

<script>
document.addEventListener("DOMContentLoaded", function () {
    const modal = document.getElementById("applyJobModal");
    const closeBtn = document.querySelector(".close");
    const applyButtons = document.querySelectorAll(".apply-btn");
    
    applyButtons.forEach(button => {
        button.addEventListener("click", function () {
            const jid = this.getAttribute("data-jid");
            const rid = this.getAttribute("data-rid");

            // Set hidden input values in the form
            document.getElementById("jid").value = jid;
            document.getElementById("rid").value = rid;

            // Open modal
            modal.style.display = "block";
        });
    });

    // Close modal when clicking on "X"
    closeBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Close modal when clicking outside
    window.addEventListener("click", function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
});
</script>

</body>
</html>