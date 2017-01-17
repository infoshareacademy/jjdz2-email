<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="messages" var="msg"/>
<html lang="en">
<head>
    <title>JBD Email Search Engine</title>

    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <script src="../resources/jquery/jquery-3.1.1.min.js"></script>
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
    <link href="../resources/css.css" rel="stylesheet" type="text/css">
    <script src="../resources/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
</head>
<body>
<jsp:directive.include file="../header.jsp"/>
<div id="container">
    <div class="jumbotron">
        <h2 id="jumbotron"><fmt:message bundle="${msg}" key="specify"/></h2>
    </div>
    <div class="emailsSearch">
        <div class="col-md-4">
            <form method="post" action="emails">
                <span class="requiredEmailPath">*</span>
                <input type="text" class="form-control" placeholder="<fmt:message bundle="${msg}" key="filePath"/>" name="emailPath" id="email"
                       value="${emailFile}">
                <span>
                    ${noEmailPathGivenErrorMessage}
                </span><br>
                <span class="multivalueField">**</span>
                <input type="text" class="form-control" placeholder="<fmt:message bundle="${msg}" key="emailaddr"/>" name="email"
                       value="${emails}"><br>
                <input type="text" class="form-control" placeholder="<fmt:message bundle="${msg}" key="startDate"/>" name="startDate"
                       value="${startDate}"><br>
                <input type="text" class="form-control" placeholder="<fmt:message bundle="${msg}" key="endDate"/>" name="endDate"
                       value="${endDate}"><br>
                <span class="multivalueField">**</span>
                <input type="text" class="form-control" placeholder="<fmt:message bundle="${msg}" key="keyword"/>" name="keywords" value="${keywords}">
                <br/>
                <p class="requiredFields">
                    <fmt:message bundle="${msg}" key="reqField"/><br/>
                    <fmt:message bundle="${msg}" key="commas"/><br/><br/>
                </p>
                <span class="numbersMsg"><fmt:message bundle="${msg}" key="phoneNumb"/></span><br/>
                <span class="phoneNumbersSelection">
                         <label><input type="checkbox" name="phoneNumbers" class="phoneNumbers" value="yes"><fmt:message bundle="${msg}" key="yes"/></label>
                         <label><input type="checkbox" name="phoneNumbers" class="phoneNumbers"
                                       value="no"><fmt:message bundle="${msg}" key="no"/></label><br/><br>
                    </span>
                <input class="btn btn-warning" type="submit" value="<fmt:message bundle="${msg}" key="searchEmail"/>">
            </form>
            <p>
            <form action="../keywords.jsp">
                <input class="btn btn-warning" type="submit" value="<fmt:message bundle="${msg}" key="goTokeywordsFinder"/>"
                       name="goBackToKeywordsFinder">
            </form>
            </p>
            <form action="index.jsp">
                <input class="btn btn-warning" type="submit" value="<fmt:message bundle="${msg}" key="goToMainPage"/>"
                       name="goBackToKeywordsFinder">
            </form>

        </div>
        <div class="col-md-8">
            <div>
                <span class="emailsFoundMsg">${emailsFound}</span> <br/>
                <ol>
                    <c:forEach items="${finalEmailSet}" var="email" varStatus="theCount">
                        <li> ${email.from}: ${email.subject}
                            <span hidden id="semailContent"> ${email.content} </span>
                            <input class="btn btn-warning smaller" type="button" value="View email" data-toggle="modal"
                                   data-target="#${theCount.index}">
                            <div hidden id="${theCount.index}" class="modal fade" role="dialog">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title"><span
                                                    class="emailSubject">Email from</span> ${email.from}
                                                <span class="emailDate">(${email.data})</span></h4>
                                        </div>
                                        <div class="modal-body">
                                            <span class="emailSubject"> Subject: </span> ${email.subject}
                                        </div>
                                        <div class="modal-body">
                                                ${email.content}
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-warning" data-dismiss="modal">Close
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ol>
            </div>
            <div>
                <span class="phoneNumbersFoundMsg">${phoneNumbersFound}</span> <br/>
                <ol>
                    <c:forEach items="${displayNumbers}" var="phone">
                    <li> ${phone.key} || ${phone.value}
                        </c:forEach>
                </ol>
            </div>
        </div>
    </div>
</div>
<jsp:directive.include file="../footer.jsp"/>
</body>
</html>
