<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Witaj!</h1>
    <p>Dodaj lub usuń listę administratorów</p>
    <p>Welcome! ${sessionData.username} </p>
</body>
<div>
    <form method="post" action="search">
        <input type="submit" value="Search">
        keywords: <input type="text" name="keywords"> <br/>
    </form>
    <ul>
        <c:forEach items="${userList}" var="user">
        <li> ${user.username}
            </c:forEach>
    </ul
    <p>${userList}</p>
</div>
</html>
