<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
</head>
<style type="text/css">
    body{
        background-image: url("https://w-dog.ru/wallpapers/15/10/541651100390439.jpg");
        background-size: cover;
        background-attachment: fixed;
        background-position: center center;
    }
    input.but {
        display: inline-block;
        color: rgb(68,68,68);
        text-decoration: none;
        padding: .2em 1.2em;
        outline: none;
        border: 1px solid rgba(0,0,0,.1);
        border-radius: 2px;
        background: rgb(245,245,245) linear-gradient(#f4f4f4, #f1f1f1);
        transition: all .218s ease 0s;
    }
    input.but:hover {
        color: rgb(24,24,24);
        border: 1px solid rgb(198,198,198);
        box-shadow: 0 5px 10px rgba(0,0,0,.1);
    }

    A {
        color: white;
        text-decoration: none;
    }
    A:visited {
        color: white;
        text-decoration: none;
    }
    A:hover {
        color: white;
        text-decoration: underline;
    }

    table {
        border-spacing: 0;
        empty-cells: hide;
        border-collapse: collapse;
    }
    td {
        padding: 10px 20px;
        text-align: center;
        transition: all 0.5s linear;

        border-style: solid;
        border-color: black;
        border-width: 1px;
    }
    td:first-child {
        text-align: left;
        font-weight: bold;
    }
    th {
        padding: 10px 20px;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
    }
    td:nth-child(even) {
        background: #FFB273;
    }
    td:nth-child(odd) {
        background: #BF7130;
    }
    th:nth-child(even)  {
        background: #FFB273;
    }
    th:nth-child(odd)  {
        background: #BF7130;
    }
    tr:hover td{
        background: lightskyblue;
    }
</style>
<h1 style="color: white">Книги:</h1>
<body>
<c:choose>
<c:when test="${requestScope.books.size() == 0}">
    <div style="margin-left: 50px">На данный момент книг нет</div>
</c:when>
    <c:otherwise>
    <table align="center">
        <tr>
            <th>Идентификатор книги</th>
            <th>Название</th>
            <th>Автор</th>
            <th>Издательство</th>
            <th>Дата издания</th>
            <th>Количество</th>
            <th>Библиотека</th>
        </tr>
                <c:forEach var="book" items="${requestScope.books}">
                    <tr>
                        <td><c:out value="${book.getId_book()}"/></td>
                        <td><c:out value="${book.getName_book()}"/></td>
                        <td><c:out value="${book.getAuthor()}"/></td>
                        <td><c:out value="${book.getPublish_house()}"/></td>
                        <td><c:out value="${book.getPublish_date()}"/></td>
                        <td><c:out value="${book.getQuantity()}"/></td>
                        <td><c:out value="${book.getAddress()}"/></td>
                        <td align="center">
                            <form action="/edit-book" method="get">
                                <input hidden type="text" name="id" value="${book.getId_book()}">
                                <input class="but" value="Изменить" type="submit">
                            </form>
                            <form action="/books" method="post">
                                <input hidden type="text" name="id" value="${book.getId_book()}">
                                <input class="but" value="Удалить" type="submit">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
    </table>
    </c:otherwise>
</c:choose>
<p align="right"><a style="margin-right: 50px; font-size: larger" href="/add-book">Добавить</a>
    <a style="margin-right: 50px; font-size: larger" href="/">Назад</a>
</p>
</body>
</html>
