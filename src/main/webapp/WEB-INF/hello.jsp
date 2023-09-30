<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>!!! Hello Quest !!!</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #041f37; /* Темно-синий цвет, напоминающий ночное небо */
            margin: 0;
            padding: 0;
            color: #fff; /* Белый текст для контраста */
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
            font-size: 18px;
            color: #ccc; /* Светло-серый текст */
        }

        .highlight {
            color: #ff6600; /* Оранжевый выделенный текст */
            font-weight: bold;
        }

        .button {
            display: block;
            margin: 0 auto;
            padding: 15px 30px;
            background-color: #ffcc00; /* Желтая кнопка */
            color: #041f37; /* Темно-синий текст на кнопке */
            text-decoration: none;
            border-radius: 25px;
            font-size: 20px;
            margin-top: 20px;
            transition: background-color 0.3s;
            cursor: pointer;
        }

        .button:hover {
            background-color: #ff9900; /* Изменение цвета при наведении */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="container">
        <h1>Добро пожаловать, квест написан 30.09.2023 - Евгением Луценко, как проэкт для курса javarush, ЖЕЛАЮ УДАЧИ</h1>
        <c:if test="${sessionScope.currentQuestion != null}">
            <p>${sessionScope.currentQuestion.condition}</p>
        </c:if>
        <form action="/quest-servlet" method="GET">
            <button type="submit" class="button">Начать тест</button>
        </form>
    </div>
</div>
</body>
</html>