<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Librarians</title>
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
        background-size: cover;
        background-attachment: fixed;
        background-position: center center;
        font-family: serif;
        font-style: oblique;
    }
</style>
<body>
<p><div style="font-weight: bold; margin-top: 40px; margin-left: 140px">Список библиотекарей:</div>
<ul style="margin-top: 20px; margin-left: 140px">
<c:forEach var="librarian" items="${requestScope.librarians}">
        <li>
            Идентификационный номер: <c:out value="${librarian.getId_librarian()}" />
            <p style="margin-left: 40px">Имя: <c:out value="${librarian.getName_librarian()}" /></p>
            <p style="margin-left: 40px">Библиотека: <c:out value="${librarian.getAddress()}" /></p></a>
        </li>
</c:forEach>
</ul>
<p style="position: fixed; top: 70%; left: 67%"><a style="color: darkred; font-size: larger" href="/">Назад</a></p>
</body>
</html>
