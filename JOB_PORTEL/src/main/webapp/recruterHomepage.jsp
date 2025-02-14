<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="recruterBean.*,java.util.*,JavaBeans.*"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recruiter Portal</title>
    <link rel="stylesheet" href="css/recruterHome.css">
    
</head>
<body>

<%
    Recruter r = (Recruter) session.getAttribute("recruter");
%>

<nav>
        <div class="navbar">
            <div class="title">JobPortal</div>
            <form action="/search" method="GET" class="search_bar">
                <input id="searchInput" placeholder="Enter your text..." class="input" name="query" type="text" required>
                <button type="submit" class="search_btn">Search</button>
            </form>
            <div class="nav-links">
                <a href="myjobs">MYJOBS</a>
                <a href="#about">APPLIED</a>
                <a href="uploadpost">UPLOAD POST</a>
                <a href="addjobs.html">UPLOAD JOBS</a>
                 <a href="#" class="button" onclick="openProfilePopup()"><%=r.getName() %></a>
            </div>
        </div>
    </nav>





<div class="mainCont">
        <div class="post-container">
            <%
            List<Posts> posts = (List<Posts>) request.getAttribute("posts");
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
                <div class="post-content post-form">
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
    </div>
	
	 <div id="profilePopup" class="popup">
        <div class="popup-content card">
            <span class="close" onclick="closeProfilePopup()">&times;</span>
            <div class="card__border"></div>
            <div class="card_title__container">
                <h2 class="card_title">Recruiter Profile</h2>
                <p class="card_paragraph">Your professional details</p>
            </div>
            <hr class="line">
    
            <ul class="card__list">
                <li class="card__list_item">
                    <span class="check"><svg class="check_svg" viewBox="0 0 16 16"><path d="M5.5 11.5l-3-3L2 7l3.5 3.5L14 2l.5.5z"/></svg></span>
                    <span class="list_text"><strong>Name:</strong> <%= r.getName() %></span>
                </li>
                <li class="card__list_item">
                    <span class="check"><svg class="check_svg" viewBox="0 0 16 16"><path d="M5.5 11.5l-3-3L2 7l3.5 3.5L14 2l.5.5z"/></svg></span>
                    <span class="list_text"><strong>Surname:</strong> <%= r.getSirname() %></span>
                </li>
                <li class="card__list_item">
                    <span class="check"><svg class="check_svg" viewBox="0 0 16 16"><path d="M5.5 11.5l-3-3L2 7l3.5 3.5L14 2l.5.5z"/></svg></span>
                    <span class="list_text"><strong>Company ID:</strong> <%= r.getComId() %></span>
                </li>
                <li class="card__list_item">
                    <span class="check"><svg class="check_svg" viewBox="0 0 16 16"><path d="M5.5 11.5l-3-3L2 7l3.5 3.5L14 2l.5.5z"/></svg></span>
                    <span class="list_text"><strong>Email:</strong> <%= r.getEmail() %></span>
                </li>
                <li class="card__list_item">
                    <span class="check"><svg class="check_svg" viewBox="0 0 16 16"><path d="M5.5 11.5l-3-3L2 7l3.5 3.5L14 2l.5.5z"/></svg></span>
                    <span class="list_text"><strong>Phone:</strong> <%= r.getPhone() %></span>
                </li>
            </ul>
    
            <hr class="line">
    
            <form action="logout" method="post">
                <button type="submit" class="button">Logout</button>
            </form>
        </div>
    </div>
	



<!-- Footer -->
<div class="footer">
    <p>&copy; 2025 Recruiter Portal. All rights reserved.</p>
</div>

<!-- JavaScript for Sidebar & Popup -->
<script>
function openProfilePopup() {
    document.getElementById("profilePopup").style.display = "flex";
}

// Close the profile popup
function closeProfilePopup() {
    document.getElementById("profilePopup").style.display = "none";
}
</script>

</body>
</html>
