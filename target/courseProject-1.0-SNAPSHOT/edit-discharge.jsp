<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit discharge</title>
</head>
<style type="text/css">
    body{
        background-image: url("https://p4.wallpaperbetter.com/wallpaper/767/594/322/books-library-bokeh-depth-of-field-wallpaper-preview.jpg");
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
        background: lightgray;
    }
    a.but {
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
    a.but:hover {
        color: rgb(24,24,24);
        border: 1px solid rgb(198,198,198);
        background: lightgray;
    }
</style>
<h1 style="margin-left: 35%; font-style: oblique; margin-top: 2%; color: white;">Редактирование выписки:</h1>
<body>
<form action="/edit-discharge" method="post">
    <input hidden value="${requestScope.id}" name="id">
    <p style="margin-left: 35%; margin-top: 11%; color: white; font-style: oblique;font-size:larger"><label>Введите новый срок возвращения:</label>
        <input required  maxlength="10" type="text" name="date" pattern="[0-9]{1,2}\s[а-я]{3,7}" value="${requestScope.period}"></p>
    <p style="margin-top: 7%; margin-left:40%"><input class="but" type="submit" value="Изменить">
        <a class="but" style="margin-left: 125px" href="/discharges">Отмена</a></p>
</form>
</body>
</html>
