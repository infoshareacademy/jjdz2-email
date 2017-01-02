<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="LogoutFB.js">
</script>
<h1>Witaj!</h1>
<p>Dodaj lub usuń listę administratorów</p>
<p>Welcome! ${sessionData.username} </p>
<button onclick="Logout()">Logout From FB</button>

</body>
<div>
    <form method="post" action="search">
        <input type="submit" value="Search">
        keywords: <input type="text" name="keywords"> <br/>
    </form>
    <p>Chceck box to make </p>
    <form method="post" action="update">
        <ul>
            <c:forEach items="${userList}" var="user">
                <li> ${user.id} . ${user.username} - ${user.privilege}<input type="checkbox" name="isPreviliged"
                                                                             value=${user.id}></li>
            </c:forEach>
            <input type="submit" value="Update">
            keywords: <input type="text" name="keywords"> <br/>
        </ul
    </form>
    <p>${userList}</p>
</div>
</html>
