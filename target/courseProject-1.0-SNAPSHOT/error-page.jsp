<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
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
</style>
<body bgcolor="white">
    <h1 align="center">Произошла ошибка при обработке запроса...</h1>
    <h2 align="center"><c:out value="${requestScope.error}"/></h2>
    <img src="https://cdn.dribbble.com/users/114645/screenshots/3116766/500-cb.gif"
         alt="О нет" width="450" height="300" style="margin-left: 33%;">
    <h3 align="center"> <a href="/">Вернуться на главную страницу</a></h3>
</body>
</html>
