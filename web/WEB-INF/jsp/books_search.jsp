<%@ page import="ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.Book" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<s:url value="/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet"/>
    <title>Hello :: Spring Application</title></head>
<body>
<h1>Hello - Spring Application</h1>
<table>
    <tr>
    <th>Название</th>
    <th>Автор</th>
    <th>Комментарий</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.comment}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>