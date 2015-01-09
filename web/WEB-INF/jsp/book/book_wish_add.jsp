<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<link href="<s:url value="/res/frameworks/bootstrap-select/css/bootstrap-select.min.css" />" rel="stylesheet"
      type="text/css"/>
<script src="<s:url value="/res/frameworks/bootstrap-select/js/bootstrap-select.min.js" />"
        type="text/javascript"></script>
<link href="<s:url value="/res/frameworks/jasny-bootstrap/css/jasny-bootstrap.min.css" />" rel="stylesheet"
      type="text/css"/>
<script src="<s:url value="/res/frameworks/jasny-bootstrap/js/jasny-bootstrap.min.js" />"
        type="text/javascript"></script>
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Добавить книгу</h3>
    </div>
    <div class="panel-body">
        <form id="bookWishAddForm" role="form" method="post" action="./user/addBookWish">
            <div class="form-group">
                <label for="authorName">Автор:</label>
                <input type="text" class="form-control" name="authorName" id="authorName" placeholder="Имя автора">
            </div>
            <div class="form-group">
                <label for="bookTitle">Название:</label>
                <input type="text" name="bookTitle" class="form-control" id="bookTitle" placeholder="Название книги">
            </div>
            <button id="submitBookWishAddFormButton" class="btn btn-info">Добавить</button>
        </form>
    </div>
</div>