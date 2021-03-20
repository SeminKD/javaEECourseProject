<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student`s books</title>
</head>
<style type="text/css">
    A {
        color: #000;
        text-decoration: none;
    }
    A:visited {
        color: #000;
        text-decoration: none;
    }
    A:hover {
        color: #000;
        text-decoration: underline;
    }
    body{
        background-image: url("https://img1.goodfon.ru/original/800x480/5/c2/kniga-bumaga-razvorot.jpg");
        background-size: 300% 300%;
        background-position: -350px -350px;
        font-family: serif;
        font-style: oblique;
    }
</style>
<h1 style="margin-left: 50px">Книги выбранного студента:</h1>
<body>
<c:choose>
    <c:when test="${requestScope.books.size() == 0}">
        <div style="margin-left: 80px">Книги на руках отсутствуют</div>
    </c:when>
    <c:otherwise>
        <c:forEach var="object" items="${requestScope.books}">
        <ul style="margin-left: 50px">
            <li>
                Книга:  <c:out value="${object.getAuthor()}" />, <c:out value="${object.getName_book()}" />,
                изд. <c:out value="${object.getPublish_house()}" /> <c:out value="${object.getPublish_date()}" />
                <p style="margin-left: 40px">Дата получения: <c:out value="${object.getIssue_date()}" /></p>
                <p style="margin-left: 40px">Срок сдачи: <c:out value="${object.getReturn_period()}" /></p>
            </li>
        </ul>
        </c:forEach>
    </c:otherwise>
</c:choose>
<p><a style="margin-left: 550px; color: darkred; font-size: larger" href="/students">Назад</a></p>
</body>
</html>
