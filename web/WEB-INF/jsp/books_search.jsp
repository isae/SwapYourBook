<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<s:url value="/res/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
    <script src="<s:url value="/res/js/jquery-1.11.1.js" />" type="text/javascript"></script>
    <script src="<s:url value="/res/frameworks/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
    <link href="<s:url value="/res/frameworks/select2/select2.css" />" rel="stylesheet"/>
    <script src="<s:url value="/res/frameworks/select2/select2.min.js" />"></script>
    <link href="<s:url value="/res/frameworks/smoothzoom/szoom.css" />" rel="stylesheet"/>
    <script type="text/javascript" src="<s:url value="/res/frameworks/smoothzoom/szoom.js" />"></script>
    <title>Hello :: Spring Application</title></head>
<script>
    $(window).load( function() {
        $('img').smoothZoom();
    });
    $(document).ready(function () {
        $("#e1").select2();
    });
</script>
<body>
<h1>Hello - Spring Application</h1>
<table>
    <tr>
        <th>Название</th>
        <th>Автор</th>
        <th>Картинка</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td><p><img rel="zoom" class="zoomable" src="${book.imageLink}" /></p></td>
        </tr>
    </c:forEach>

</table>
<select id="e1">
    <option value="AL">Alabama</option>
    <option value="AL1">Alabama23</option>
    <option value="AL2">Alaasdasbama23</option>
    <option value="WY">Wyoming</option>
</select>
</body>
</html>