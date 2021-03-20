<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit student</title>
</head>
<style type="text/css">
    body{
        background-image: url("https://img3.akspic.ru/previews/9/3/4/4/3/134439/134439-naushniki-tekst-obrazovanie-avtor-marketing-x750.jpg");
        background-size: cover;
        background-attachment: fixed;
        background-position: center center;
    }
    a.but {
        color: #fff;
        outline: none;
        text-decoration: none;
        background: rgb(212,75,56);
        padding: .5em 2em;
        border-radius: 6px;
    }
    a.but:hover { background: rgb(232,95,76); }

    input.but2 {
        color: white;
        height: 32px;
        outline: none;
        text-decoration: none;
        padding: .5em 2em;
        border-style: none;
        border-radius: 6px;
        background: linear-gradient(#f3ae0f, #E38916) #e38916;
        transition: 0.2s;
    }
    input.but2:hover {background: linear-gradient(#f5ae00, rgba(246,237,95,0.88)) #f5ae00;}
</style>
<h1 style="color: darkgoldenrod; margin-left: 50px; margin-top: 20px;">Изменение данных студента:</h1>
<body>
<form method="post" action="/edit-student">
    <p><label style="color:#F3AE0F; font-size: larger; margin-left: 100px;">Выберите студента для изменения:</label>
        <select name="id">
            <c:forEach var="student" items="${requestScope.students}">
                <option value=${student.getId_student()}>
                    <c:out value="${student.getId_student()}"/>,
                    <c:out value="${student.getName_student()}"/>,
                    <c:out value="${student.getStud_group()}"/>
                </option>
            </c:forEach>
        </select>
    </p>
    <p>
        <label style="color:#F3AE0F; font-size: larger; margin-left: 200px;">Введите имя студента:</label>
        <input required maxlength="150" type="text" name="name">
    <p><label style="color:#F3AE0F; font-size: larger; margin-left: 300px;">Введите номер учебной группы:</label>
        <input required maxlength="12" type="text" name="group"></p>
    <p><input class="but2" style="margin-left: 300px" type="submit" value="Изменить">
        <a style="margin-left: 163px;" class="but" href="/students">Отмена</a></p>
</form>
</body>
</html>
