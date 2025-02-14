<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="auth.*,JavaBeans.*,java.util.*"
    %>
<!DOCTYPE html>
<html>
 <link rel="stylesheet" href="css/style.css">
<head>
<meta charset="UTF-8">
   <title>JobEntry - Job Portal Website Template</title>
    
</head>
<body>
	<%
	User user=(User)session.getAttribute("user");
	%>
	
	
	 <nav class="navbar">
        <div class="logo-container">
            <div class="logo">JobPortal</div>
            <h1 class="animated-text">Welcome to JobPortal</h1>
            <p class="fade-in-text">Find your dream job today!</p>
        </div>
        
        <ul class="nav-links">
            <li><a href="homepage.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span>Home</span>
            </a></li>
            <li><a href="allJobs">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span>Jobs</span>
            </a></li>
            <li><a href="Post">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span>Post</span>
            </a></li>
            <li><a href="contact.html">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span>About</span>
            </a></li>

            <li><a href="updateProfile.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span><%=user.getName() %></span>
            </a></li>
        </ul>
    </nav>
	
	
        
       <div class="mainCont">

      <div class="post-container">
        <%
        List<Posts> posts = (List<Posts>) request.getAttribute("alljobs");
        if (posts != null) {
            for (Posts p : posts) {
                // Convert the image byte array to a Base64 string
                String base64Image = Base64.getEncoder().encodeToString(p.getImage());
        %>
        <div class="post">
            <div class="post-header">
                <img src="img/user.png" alt="User" class="user-avatar">
                <h3 class="username"><%= p.getUsername() %></h3>
            </div>
            <div class="post-content">
                <h2 class="post-title"><%= p.getTitle() %></h2>
                <p class="post-description"><%= p.getDesc() %></p>
                <!-- Use the Base64 string in the src attribute -->
                <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Post Image" class="post-image">
            </div>
            <div class="post-actions">
                <button class="action-button">Like</button>
                <button class="action-button">Comment</button>
                <button class="action-button">Share</button>
            </div>
        </div>
        <%
            }
        }
        %>
    </div>

    <div id="postForm" class="post-form">
        <h1>Upload Post</h1>
        <form action="submit_post" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="form-group">
                <label for="desc">Description:</label>
                <textarea id="desc" name="desc" required></textarea>
            </div>
            <div class="form-group">
                <label for="image">Upload Image:</label>
                <input type="file" id="image" name="image" accept="image/*" required>
            </div>
            <div class="form-group">
                <button type="submit">Submit Post</button>
            </div>
        </form>
    </div>
</div>

 <footer class="footer">
        <div class="footer-content">
            <div class="footer-section">
                <h3>Quick Links</h3>
                <ul>
                    <li><a href="#home">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span>Home</span>
                    </a></li>
                    <li><a href="#jobs">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span>Jobs</span>
                    </a></li>
                    <li><a href="#services">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span>Services</span>
                    </a></li>
                    <li><a href="#about">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span>About</span>
                    </a></li>
                </ul>
            </div>
            <div class="footer-section">
                <h3>Contact Us</h3>
                <p>Email: info@jobportal.com</p>
                <p>Phone: +1 234 567 890</p>
                <p>Address: 123 Job Street, City, Country</p>
            </div>
            <div class="footer-section">
                <h3>Follow Us</h3>
                <ul class="social-links">
                    <li><a href="https://facebook.com" target="_blank">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span>Facebook</span>
                    </a></li>
                    <li><a href="https://twitter.com" target="_blank">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span>Twitter</span>
                    </a></li>
                    <li><a href="https://linkedin.com" target="_blank">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span>LinkedIn</span>
                    </a></li>
                    <li><a href="https://instagram.com" target="_blank">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span>Instagram</span>
                    </a></li>
                </ul>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2023 JobPortal. All rights reserved.</p>
        </div>
    </footer>
         <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    
    <!-- profile Javascript -->
    <script>
    document.addEventListener("DOMContentLoaded", function () {
        const postLink = document.querySelector("li a[href='Post']"); // Target the "Post" link
        const postForm = document.getElementById("postForm");

        if (postLink && postForm) {
            postLink.addEventListener("click", function (event) {
                event.preventDefault(); // Prevent page reload
                postForm.style.display = "block"; // Show form
            });

            // Close form when clicking outside
            document.addEventListener("click", function (event) {
                if (!postForm.contains(event.target) && event.target !== postLink) {
                    postForm.style.display = "none"; // Hide form
                }
            });
        }
    });
</script>
</body>
</html>