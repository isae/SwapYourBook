<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script src="<s:url value="/res/js/jquery-form.js" />" type="text/javascript"></script>

<h1>Отдам</h1>
<table class="table table-hover">
    <thead>
    <tr>
        <td>Название</td>
        <td>Автор</td>
        <td>Фото</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${userOffers}">
        <tr style="cursor: pointer" class="clickableBook">
            <td class="hidden offerID">${book.bookid}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td><img rel="zoom" class="zoomable" src="./book/image?imageID=${book.thumbnailid}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button id="openBookAddFormButton" style="margin-top: 15px; margin-bottom: 15px;" data-toggle="collapse"
        data-target="#bookAddPane"
        aria-expanded="false" aria-controls="bookAddPane"
        href="./book/addBookForm" type="button"
        class="btn btn-primary btn-lg active">Добавить книгу
</button>
<div class="collapse container-fluid" id="bookAddPane">
    <jsp:include page="/book/addBookForm"/>
</div>