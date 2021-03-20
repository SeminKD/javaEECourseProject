<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library`s books</title>
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
<h1 style="margin-left: 50px">Книги в выбранной библиотеке:</h1>
<body>
<c:forEach var="book" items="${requestScope.books}">
    <ul style="margin-left: 50px">
        <li>
            Книга:  <c:out value="${book.getAuthor()}" />, <c:out value="${book.getName_book()}" />,
            изд. <c:out value="${book.getPublish_house()}" /> <c:out value="${book.getPublish_date()}" />
            <p style="margin-left: 40px">Количество: <c:out value="${book.getQuantity()}" /></p>
        </li>
    </ul>
</c:forEach>
<p><a style="margin-left: 550px; color: darkred; font-size: larger" href="/libraries">Назад</a></p>
</body>
</html>
