<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Students</title>
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
    .mainmenubtn {
        background-image: url("https://img1.goodfon.ru/original/800x480/5/c2/kniga-bumaga-razvorot.jpg");
        background-size: 300% 300%;
        background-position: -350px -320px;
        font-family: serif;
        font-style: oblique;
        border-style: solid;
        border-color: black;
        border-radius: 5px;
        color: black;
        size: auto;
        cursor: pointer;
        margin-top:20px;
    }
    .dropdown {
        position: relative;
        display: inline-block;
    }
    .dropdown-child {
        display: none;
        background-color: rgba(95,107,149,0.88);
        min-width: 20px;
    }
    .dropdown-child a {
        padding: 20px;
        color: black;
        text-decoration: none;
        display: block;
    }
    .dropdown-child a:hover{
        text-decoration: underline;
    }
    .dropdown:hover .dropdown-child {
        display: block;
    }

</style>
<body>
<c:choose>
    <c:when test="${requestScope.students.size() == 0}">
        <p><div style="font-weight: bold; margin-top: 30px; margin-left: 135px">Студенты отсутствуют</div>
    </c:when>
    <c:otherwise>
        <p><div style="font-weight: bold; margin-top: 40px; margin-left: 140px">Список студентов:</div>
        <div style="position: absolute; left: 430px; top: 20px" class="dropdown">
        <button  class="mainmenubtn">Учет студентов</button>
        <div  class="dropdown-child">
            <a href="/add-student">Добавить</a>
            <a href="/edit-student">Изменить</a>
            <a href="/delete-student">Удалить студента</a>
        </div>
    </div>
        <ul style="margin-top: 20px; margin-left: 140px">
    <c:forEach var="student" items="${requestScope.students}">
            <li><a title="Просмотр книг на руках студента" href="/students-books?id=<c:out value="${student.getId_student()}" />">
                Студенческий номер: <c:out value="${student.getId_student()}" />, Имя: <c:out value="${student.getName_student()}" />
                <p>Группа: <c:out value="${student.getStud_group()}" /></p></a>
            </li>
    </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>
        <p style="position: fixed; top: 70%; left: 67%"><a style="color: darkred; font-size: larger" href="/">Назад</a></p>
</body>
</html>
