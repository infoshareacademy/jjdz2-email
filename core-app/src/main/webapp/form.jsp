<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>yolo</title>
</head>
<body>
    <p>form:</p>
    <div>
        <form method="post" action="sendData">
            email: <input type="text" name="email"> <br />
            date: <input type="text" name="date"> <br />
            keywords: <input type="text" name="keywords"> <br />
            <input type="submit" value="Send">
        </form>
    </div>
    <div>
        <ul>
            <c:forEach items="${results}" var="email">
            <li> ${email.subject}
            </c:forEach>
        </ul>
    </div>
</body>
</html>
