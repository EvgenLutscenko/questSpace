<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: radial-gradient(#002147, #00132b);
            color: #fff;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 40px;
            background-color: rgba(0, 0, 0, 0.8); /* Полупрозрачный черный фон контейнера */
            box-shadow: 0 0 20px rgba(255, 255, 255, 0.2); /* Белая тень */
            border-radius: 10px;
        }

        h1 {
            font-size: 36px;
            color: #ffcc00; /* Желтый заголовок, символизирующий звезды */
            margin-bottom: 20px;
        }

        p {
            font-size: 24px;
            font-weight: bold;
            color: #ffcc00;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh; /* Занимает 100% высоты видимой области */
            margin: 0;
        }

        .radio-label {
            font-size: 28px; /* Увеличил размер текста для вопросов */
            margin-bottom: 30px; /* Увеличил отступ между вопросами */
            color: #fff; /* Белый текст для вопросов */
            width: 70%; /* Задайте ширину вопроса по вашему желанию, например, 70% */
        }

        .radio-input {
            margin-right: 15px; /* Увеличил расстояние между радиокнопками */
        }

        .submit-button {
            margin-top: 30px; /* Увеличил отступ перед кнопкой */
            padding: 15px 30px; /* Вернул старый размер кнопки */
            font-size: 24px; /* Увеличил размер текста на кнопке */
        }

        .submit-button:hover {
            background-color: #ff9900; /* Изменение цвета при наведении */
        }

        .stats {
            position: absolute;
            bottom: 10px;
            left: 10px;
            background-color: rgba(0, 0, 0, 0.7); /* Темный фон */
            color: #fff; /* Белый текст */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: left;
            font-size: 16px;
            max-width: 300px;
            line-height: 1.5;
        }

        .stats p {
            font-weight: bold;
            margin-bottom: 10px;
        }

        .stats ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .stats li {
            margin-bottom: 8px;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="/quest-servlet" method="POST">
        <p class="question">${sessionScope.currentQuestion.condition}</p>
        <c:forEach var="question" items="${sessionScope.currentQuestion.questions}" varStatus="loop">
            <c:set var="answer" value="${sessionScope.currentQuestion.answers[loop.index]}"/>
            <label class="radio-label">
                <input type="radio" name="choice" value="${answer}" class="radio-input"
                       <c:if test="${loop.index == 0}">checked</c:if>> ${question}
            </label>
        </c:forEach>
        <button type="submit" class="submit-button">Отправить</button>
    </form>
</div>

<div class="stats">
    <p>Доп-инфа:</p>
    <ul>
        <c:forEach items="${sessionScope.inf}" var="entry">
            <li>${entry.key}: ${entry.value}</li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
