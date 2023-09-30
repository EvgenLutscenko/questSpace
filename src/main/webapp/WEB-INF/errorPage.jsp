<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>
<div>
    <h1>Error</h1>
    <c:if test="${not empty problem}">
        <p>Explanation: ${problem.explanation}</p>
    </c:if>
    <p>Additional error details or instructions can be provided here.</p>
</div>
</body>
</html>
