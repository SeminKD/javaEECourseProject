<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add discharge</title>
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
<h1 style="margin-left: 37%; font-style: oblique; margin-top: 2%; color: white;">Добавление выписки:</h1>
<body>
    <form action="/add-discharge" method="post">
        <p style="margin-left: 36%;font-style: oblique; margin-top: 3%; color: white; font-size:larger"><label>Выберите студента:</label>
            <select  required name="id_student">
            <c:forEach var="student" items="${requestScope.students}">
                <option  value=${student.id_student}>
                    <c:out value="${student.id_student}"/>,
                    <c:out value="${student.name_student}"/>,
                    <c:out value="${student.stud_group}"/>
                </option>
            </c:forEach>
        </select></p>
            <p style="color: white; font-style: oblique; margin-left: 34%; margin-top: 4%; font-size: larger"><label>Выберите книгу:</label>
                <select required name="id_book">
                <c:forEach var="book" items="${requestScope.books}">
                    <option value=${book.id_book}>
                        <c:out value="${book.name_book}"/>,
                        <c:out value="${book.author}"/>,
                        <c:out value="${book.publish_house}"/>,
                        <c:out value="${book.publish_date}"/>
                    </option>
                </c:forEach>
            </select></p>
        <p style="color: white; font-style: oblique; margin-left: 32%; margin-top: 3%; font-size: larger"><label>Выдал:</label>
            <select required name="id_librarian">
            <c:forEach var="libr" items="${requestScope.librs}">
                <option value=${libr.id_librarian}>
                    <c:out value="${libr.name_librarian}"/>
                </option>
            </c:forEach>
        </select></p>
        <p style="color: white; font-style: oblique; margin-top: 3%; margin-left: 47%; font-size: larger"><label>Срок возвращения:</label>
            <input required  maxlength="10" type="text" name="period" pattern="[0-9]{1,2}\s[а-я]{3,7}"></p>
        <p style="margin-top: 3%; margin-left:37%"><input class="but" type="submit" value="Добавить">
            <a class="but" style="margin-left: 175px" href="/discharges">Отмена</a></p>
    </form>
</body>
</html>
