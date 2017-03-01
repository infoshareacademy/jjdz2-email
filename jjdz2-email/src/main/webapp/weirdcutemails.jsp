<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="messages" var="msg"/>
<html>
<head>
    <title>JBD Email Search Engine</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link href="resources/css.css" rel="stylesheet" type="text/css">
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="body">
<jsp:directive.include file="header.jsp"/>
<div id="container">
    <script type="text/javascript" src="App/LogoutFB.js">
    </script>
    <div class="jumbotron">
        <h2 id="jumbotron"><fmt:message bundle="${msg}" key="Weirdcutemailstitle"/></h2>
        <h3><fmt:message bundle="${msg}" key="passyouremail"/></h3>
    </div></div>


<input type="<strong>email</strong>" placeholder="Enter your email">

<form action="${pageContext.request.contextPath}/myservlet">
    <input type="submit" name="button1" value="Button 1" />
    <input type="submit" name="button2" value="Button 2" />
    <input type="submit" name="button3" value="Button 3" />
</form>

</form>


<jsp:directive.include file="footer.jsp"/>
</body>
</html>
