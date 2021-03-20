<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<style type="text/css">
    A{
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
    P{
        line-height: 0.9em;
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
<div style="font-weight: bold; margin-top: 30px; margin-left: 135px">Выберите одно из следующих действий:</div>
    <ul style="margin-top: 20px; margin-left: 135px">
        <p>
        <li><a href="/students">  Просмотр списка студентов............................................</a></li>
        <p>
        <li><a href="/libraries"> Просмотр списка библиотек............................................</a></li>
        <p>
        <li><a href="/librarians">Просмотр списка библиотекарей....................................</a></li>
        <p>
        <li><a href="/books">Учет книг............................................................................</a></li>
        <p>
        <li><a href="/discharges">Учет выписок.....................................................................</a></li>
    </ul>
</body>
</html>
