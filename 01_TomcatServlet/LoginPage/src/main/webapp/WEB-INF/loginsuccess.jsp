<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Success</title>
    <style>
        body {
            background-color: #1e1e2f;
            font-family: 'Trebuchet MS', sans-serif;
            text-align: center;
            padding-top: 50px;
        }
        h1 {
            color: #e74c3c;
            font-size: 36px;
            font-weight: bold;
        }
        h3 {
            color: #f39c12;
            font-size: 28px;
        }
        p {
            color: #ecf0f1;
            font-size: 18px;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 25px;
            background-color: #8e44ad;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            transition: 0.3s ease;
        }
        a:hover {
            background-color: #6c3483;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <h1>SUCCESSFUL LOGIN</h1>
    <h3>Hi <%= request.getAttribute("user") %>, Login successful!</h3>
    <p>Welcome to your account.</p>
    <a href="login.html">Logout?</a>
</body>
</html>