<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Discharges</title>
</head>
<style type="text/css">
    body{
        background-image: url("http://oboi-dlja-stola.ru/file/4893/1920x1080/crop/%D0%93%D0%BE%D1%80%D0%B0-%D0%B4%D0%BE%D0%BA%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D0%BE%D0%B2.jpg");
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
        background: #9fabac;
    }
    td:nth-child(odd) {
        background: #aca689;
    }
    th:nth-child(even)  {
        background: #9fabac;
    }
    th:nth-child(odd)  {
        background: #aca689;
    }
    tr:hover td{
        background: #aca198;
    }
</style>
<h1 style="color: white">Выписки:</h1>
<body>
<c:choose>
    <c:when test="${requestScope.dises.size() == 0}">
        <div style="margin-left: 50px">На данный момент выписки отсутствуют</div>
    </c:when>
    <c:otherwise>
        <table align="center">
            <tr>
                <th>Номер выписки</th>
                <th>Студент</th>
                <th>Книга</th>
                <th>Библиотекарь</th>
                <th>Дата получения</th>
                <th>Срок возвращения</th>
            </tr>
            <c:forEach var="dis" items="${requestScope.dises}">
                <tr>
                    <td><c:out value="${dis.getId_discharge()}"/></td>
                    <td><c:out value="${dis.getInfo_student()}"/></td>
                    <td><c:out value="${dis.getInfo_book().getName()}"/>,
                        <c:out value="${dis.getInfo_book().getAuthor()}"/>,
                        <c:out value="${dis.getInfo_book().getPublish_house()}"/>,
                        <c:out value="${dis.getInfo_book().getPublish_date()}"/>
                    </td>
                    <td><c:out value="${dis.getName_librarian()}"/></td>
                    <td><c:out value="${dis.getIssue_date()}"/></td>
                    <td><c:out value="${dis.getReturn_period()}"/></td>
                    <td align="center">
                        <form action="/edit-discharge" method="get">
                            <input hidden type="text" name="id" value="${dis.getId_discharge()}">
                            <input hidden type="text" name="period" value="${dis.getReturn_period()}">
                            <input class="but" value="Изменить срок" type="submit">
                        </form>
                        <form action="/discharges" method="post">
                            <input hidden type="text" name="id" value="${dis.getId_discharge()}">
                            <input hidden type="text" name="id_book" value="${dis.getInfo_book().getId()}">
                            <input class="but" value="Закрыть выписку" type="submit">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<p align="right"><a style="margin-right: 50px; font-size: larger" href="/add-discharge">Добавить</a>
    <a style="margin-right: 50px; font-size: larger" href="/">Назад</a>
</p>
</body>
</html>
