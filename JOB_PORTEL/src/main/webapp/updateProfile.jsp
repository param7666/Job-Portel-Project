<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="JavaBeans.*,java.util.*,profile.*"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    
    <link rel="stylesheet" href="css/updateProfile.css">
</head>
<body>
   
          <nav>
        <div class="navbar">
            <div class="title">JobPortal</div>
            <div class="nav-links">
                <a href="#" id="openEducationForm" class="open-btn">Education</a>
                <a href="#" id="openExperienceForm" class="open-btn">Experience</a>
                <a href="#" id="openSkillsForm">Skills</a>
                <a href="#">Resume</a>
            </div>
        </div>
    </nav>
    <div class="container">
    <div class="card">
        <!-- User Image (Replace with actual user image URL) -->
        <img src="user-placeholder.jpg" alt="User Image" class="user-img">

       
        <!-- User Details -->
        <div class="user-details">
            <% 
            User user = (User) session.getAttribute("user");
            %>
            <p><span>Name:</span> <%= user.getName() %></p>
            <p><span>Surname:</span> <%= user.getSirname() %></p>
            <p><span>Email:</span> <%= user.getEmail() %></p>
            <p><span>Phone:</span> <%= user.getPhone() %></p>
            <p><span>Age:</span> <%= user.getAge() %></p>
            <p><span>City:</span> <%= user.getCity() %></p>
            <p><span>State:</span> <%= user.getState() %></p>
            <p><span>Country:</span> <%= user.getCountry() %></p>
        </div>
    </div>

            <!-- Second Card: Education Details -->
            <div class="card">
                <img src="education-icon.png" alt="Education Icon" class="user-img"> <!-- Change the image -->
                <div class="user-details">
                    <h2>Education</h2>
                    <%
                    ArrayList<Education> ed = (ArrayList<Education>) request.getAttribute("edList");
                        if (ed != null) {
                            for (Education e : ed) {
                    %>
                    <div class="education-entry">
                        <h3><%= e.getDegree() %></h3>
                        <p><strong>Institute:</strong> <%= e.getInstitute() %></p>
                        <p><strong>Duration:</strong> <%= e.getsYear() %> - <%= e.geteYear() %></p>
                    </div>
                    <%
                            }
                        } else {
                    %>
                    <p>No education details available.</p>
                    <% } %>
                </div>
            </div>

        <!-- Third Card: Work Experience Details -->
        <div class="card">
            <img src="work-icon.png" alt="Work Experience Icon" class="user-img">
            <div class="user-details">
                <h2>Work Experience</h2>
                <%
                ArrayList<WorkExperiance> ex = (ArrayList<WorkExperiance>) request.getAttribute("workList");
                    if (ex != null) {
                        for (WorkExperiance e : ex) {
                %>
                <div class="detail-item">
                    <h3><%= e.getTitle() %></h3>
                    <p><strong>Company:</strong> <%= e.getCompany() %></p>
                    <p><strong>Duration:</strong> <%= e.getJoinYear() %> - <%= e.getEndYear() %></p>
                </div>
                <%
                        }
                    } else {
                %>
                <p>No work experience details available.</p>
                <% } %>
            </div>
        </div>
</div>

<!-- Education Form Popup -->
<div class="popup-overlay" id="popupOverlay">
    <div class="form-card1">
        <div class="form-card2">
            <div class="form">
                <span class="close-btn" id="closePopup">&times;</span>
                <h2 class="form-heading">Add Education</h2>
                <form action="EducationServlet" method="POST">
                    <div class="form-field">
                        <input type="text" name="degree" class="input-field" placeholder="Degree (e.g. B.Tech)" required>
                    </div>
                    <div class="form-field">
                        <input type="text" name="institute" class="input-field" placeholder="Institute Name" required>
                    </div>
                    <div class="form-field">
                        <input type="number" name="startYear" class="input-field" placeholder="Start Year" required>
                        <input type="number" name="endYear" class="input-field" placeholder="End Year" required>
                    </div>
                    <button type="submit" class="sendMessage-btn">Save Education</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Experience Form Popup -->
<div class="popup-overlay" id="experiencePopup">
    <div class="form-card1">
        <div class="form-card2">
            <div class="form">
                <span class="close-btn" id="closeExperiencePopup">&times;</span>
                <h2 class="form-heading">Add Experience</h2>
                <form action="ExperienceServlet" method="POST">
                    <div class="form-field">
                        <input type="text" name="jobTitle" class="input-field" placeholder="Job Title (e.g. Software Developer)" required>
                    </div>
                    <div class="form-field">
                        <input type="text" name="company" class="input-field" placeholder="Company Name" required>
                    </div>
                    <div class="form-field">
                        <input type="number" name="startYear" class="input-field" placeholder="Start Year" required>
                        <input type="number" name="endYear" class="input-field" placeholder="End Year" required>
                    </div>
                    <button type="submit" class="sendMessage-btn">Save Experience</button>
                </form>
            </div>
        </div>
    </div>
</div>
    

<!-- Skills Form (Hidden by default) -->
<div class="popup-overlay" id="skillsPopup">
    <div class="form-card1 form-card2">
        <span class="close-btn" id="closeSkillsPopup">&times;</span>
        
        <div class="form">
            <div class="form-heading">
                <h2>Add Skills</h2>
            </div>
            
            <form action="SkillsServlet" method="POST">
                <div class="form-field">
                    <label for="skills" style="color: #64ffda;">Skills:</label>
                    <input type="text" name="skills" id="skills" placeholder="Enter skills separated by commas" required class="input-field">
                </div>
                <button type="submit" class="sendMessage-btn">Save Skills</button>
            </form>
        </div>
    </div>
</div>       
                
        

    <script>
    document.getElementById("openEducationForm").addEventListener("click", function(event) {
        event.preventDefault(); // Prevent default link behavior
        document.getElementById("popupOverlay").style.display = "flex";
    });
    
    document.getElementById("closePopup").addEventListener("click", function() {
        document.getElementById("popupOverlay").style.display = "none";
    });
    
    // Close the popup if user clicks outside the form
    window.addEventListener("click", function(event) {
        const popup = document.getElementById("popupOverlay");
        if (event.target === popup) {
            popup.style.display = "none";
        }
    });

    document.getElementById("openExperienceForm").addEventListener("click", function(event) {
        event.preventDefault(); // Prevent default link behavior
        document.getElementById("experiencePopup").style.display = "flex";
    });
    
    document.getElementById("closeExperiencePopup").addEventListener("click", function() {
        document.getElementById("experiencePopup").style.display = "none";
    });
    
    // Close the popup if user clicks outside the form
    window.addEventListener("click", function(event) {
        const popup = document.getElementById("experiencePopup");
        if (event.target === popup) {
            popup.style.display = "none";
        }
    });


    document.getElementById("openSkillsForm").addEventListener("click", function(event) {
        event.preventDefault(); // Prevent the default link behavior
        document.getElementById("skillsPopup").style.display = "flex"; // Show the Skills popup
    });
    
    // Close the Skills popup form
    document.getElementById("closeSkillsPopup").addEventListener("click", function() {
        document.getElementById("skillsPopup").style.display = "none"; // Hide the Skills popup
    });
    
    // Close the popup if user clicks outside the form
    window.addEventListener("click", function(event) {
        const popup = document.getElementById("skillsPopup");
        if (event.target === popup) {
            popup.style.display = "none"; // Close popup when clicking outside
        }
    }); 
    </script>
</body>
</html>