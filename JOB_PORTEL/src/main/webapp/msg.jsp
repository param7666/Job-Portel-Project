<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="auth.*"
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notification</title>
    <style>
        /* Centering the message box */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #121212;
            color: #ffffff;
            font-family: Arial, sans-serif;
        }

        .message-box {
            padding: 20px;
            border-radius: 10px;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            box-shadow: 0px 4px 30px rgba(63, 159, 227, 0.5);
            text-align: center;
            width: 350px;
        }

        .message-box h2 {
            font-size: 1.5em;
            margin-bottom: 10px;
        }

        .message-box p {
            font-size: 1.2em;
            font-weight: bold;
        }

        .back-button {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 20px;
            font-size: 1em;
            color: #ffffff;
            background: #e53fe5;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            transition: 0.3s;
        }

        .back-button:hover {
            background: #ff0080;
        }
    </style>
</head>
<body>
    <div class="message-box">
        <h2>Notification</h2>
        <p>
            <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null) {
                    out.println(msg);
                } else {
                    out.println("No message available.");
                }
            %>
        </p>
        <a href="index.jsp" class="back-button">Go Back</a>
    </div>
</body>
</html>
