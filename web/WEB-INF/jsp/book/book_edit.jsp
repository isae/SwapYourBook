<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="<s:url value="/res/js/jquery-1.11.1.js" />" type="text/javascript"></script>
    <link href="<s:url value="/res/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
    <link href="<s:url value="/res/frameworks/jasny-bootstrap/css/jasny-bootstrap.min.css" />" rel="stylesheet"
          type="text/css"/>
    <script src="<s:url value="/res/frameworks/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<s:url value="/res/frameworks/jasny-bootstrap/js/jasny-bootstrap.min.js" />"
            type="text/javascript"></script>
    <link href="<s:url value="/res/frameworks/smoothzoom/szoom.css" />" rel="stylesheet"/>
    <script type="text/javascript" src="<s:url value="/res/frameworks/smoothzoom/szoom.js" />"></script>
    <script src="<s:url value="/res/js/jquery-form.js" />" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var zoomable = $('.zoomable');
            zoomable.smoothZoom();
            zoomable.click(function (e) {
                e.stopPropagation();
            });
            $("#submitBookEditFormButton").click(function (e) {
                e.preventDefault();
                $("#bookEditForm").ajaxForm({
                    success: function (data) {
                        $(location).attr('href', '../user');
                    },
                    dataType: "text"
                }).submit();
            });
        });
    </script>
    <title>User Page</title>
</head>
<body>
<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
    <div class="container " style="background-color: lightblue">
        <div class="navbar-header">
            <a href=".." class="navbar-brand" style="color:#ffffff;"><b>SwapYourBook</b></a>
        </div>
    </div>
</header>
<div class="container">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Редактирование книги
                <div class="btn-group pull-right">
                    <a class="btn btn-sm btn-danger" data-toggle="modal" data-target="#deleteModal">Удалить</a>
                </div>
            </h3>
            <div class="clearfix"></div>
        </div>
        <div class="panel-body">
            <form id="bookEditForm" role="form" method="post" action="./editBook" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="authorName">Автор:</label>
                    <input type="text" class="form-control" name="authorName" id="authorName" placeholder="Имя автора"
                           value="${book.book.author}">
                </div>
                <input type="hidden" name="bookID" value="${book.book.bookid}">

                <div class="form-group">
                    <label for="bookTitle">Название:</label>
                    <input type="text" name="bookTitle" class="form-control" id="bookTitle" value="${book.book.title}"
                           placeholder="Название книги">
                </div>
                <div class="form-group">
                    <label for="bookDescription">Описание:</label>
                    <textarea class="form-control" name="bookDescription" id="bookDescription"
                              rows="5">${book.book.comment}</textarea>
                </div>
                <div class="form-group">
                    <div class="fileinput fileinput-exists" data-provides="fileinput">
                        <div class="fileinput-preview thumbnail" style="max-width: 100px">
                            <img rel="zoom" class="zoomable" src="./image?imageID=${book.book.thumbnailid}"/>
                        </div>
                        <div>
                        <span class="btn btn-default btn-file">
                            <span class="fileinput-exists">Change</span>
                            <input id="bookThumbnail"
                                   type="file"
                                   name="bookThumbnail"></span>
                        </div>
                    </div>
                </div>
                <input type="submit" id="submitBookEditFormButton" class="btn btn-info" value="Сохранить"/>
                <input type="button" class="btn btn-warning" value="Отмена"/>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form action="./deleteBook" method="get">
            <div class="modal-content">
                <div class="modal-header bg-danger">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Закрыть</span></button>
                    <h4 class="modal-title" id="deleteBook">Вы уверены, что хотите удалить "${book.book.title}"?</h4>
                </div>
                <input type="hidden" name="userBookID" value="${book.userBook.userbookid}">

                <div class="modal-footer">
                    <input type="submit" id="loginButton" class="btn btn-danger" value="Удалить"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>