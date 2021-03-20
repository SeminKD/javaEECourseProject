<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit book</title>
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
        background-image: url("https://www.rabstol.net/uploads/gallery/main/178/rabstol_net_books_13.jpg");
        background-size: cover;
        background-attachment: fixed;
        background-position: center center;
    }
    label{
        font-size: larger;
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
</style>
<h1 style="color: white; margin-left: 50px; margin-top: 20px;">Изменение книги:</h1>
<body>
<form action="/edit-book" method="post">
    <input hidden value="${requestScope.book.getId_book()}" name="id">
    <label style="color:white; margin-left: 100px;">Название книги:</label>
    <input required maxlength="100" type="text" name="name" value="${requestScope.book.getName_book()}">
    <p><label style="color:white; margin-left: 150px;">Автор:</label>
        <input required maxlength="150" type="text" name="author" value="${requestScope.book.getAuthor()}"></p>
    <p><label style="color:white; margin-left: 200px;">Издатель:</label>
        <input required maxlength="150" type="text" name="publish_house" value="${requestScope.book.getPublish_house()}"></p>
    <p><label style="color:white; margin-left: 250px;">Дата издания:</label>
        <input required type="date" name="publish_date"></p>
    <p><label style="color:white; margin-left: 300px;">Количество:</label>
        <input required type="number" name="quantity" value="${requestScope.book.getQuantity()}"></p>
    <label style="color:white; margin-left: 350px;">Библиотека:</label>
    <select required name="id_library">
            <c:forEach var="lib" items="${requestScope.libraries}">
                <option value=${lib.getId_library()}>
                    <c:out value="${lib.address}"/>
                </option>
            </c:forEach>
    </select>
    <p><input style="margin-left: 350px;" class="but" type="submit" value="Изменить">
        <a class="but" style="margin-left: 70px"y href="/books">Отмена</a></p>
</form>

</body>
</html>
