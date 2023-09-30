<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bad Outcome</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: radial-gradient(#002147, #00132b);
            color: #fff;
            margin: 0;
            padding: 0;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .message {
            font-size: 36px;
            margin-bottom: 20px;
        }

        .retry-button {
            padding: 15px 30px;
            background-color: #ffcc00;
            color: #041f37;
            text-decoration: none;
            border: none;
            border-radius: 25px;
            font-size: 20px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .retry-button:hover {
            background-color: #ff9900;
        }
    </style>
</head>
<body>
<div class="message">
    <p>${sessionScope.currentQuestion.conclusion}</p>
</div>
<a href="/index.jsp" class="retry-button">начать заново</a>

</body>
</html>
