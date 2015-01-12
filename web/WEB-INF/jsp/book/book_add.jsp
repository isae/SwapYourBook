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

<script src="<s:url value="/res/js/jquery.autocomplete.js" />" type="text/javascript"></script>

<link href="<s:url value="/res/css/autocomplete-style.css" />" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
    $(document).ready(function () {
        $('#authorName').autocomplete({
            serviceUrl: 'user/addOffer/authorAutocomplete',
            paramName: "requestedString",
            // max_length: 30,
            transformResult: function (response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return { value: item.tagName, data: item.id };
                    })

                };

            }
        });

        $('#bookTitle').autocomplete({
            serviceUrl: 'user/addOffer/titleAutocomplete',
            paramName: "requestedString",
            // max_length: 30,
            transformResult: function (response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return { value: item.tagName, data: item.id };
                    })

                };

            }
        });
    })

</script>
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Добавить книгу</h3>
    </div>
    <div class="panel-body">
        <form id="bookAddForm" role="form" method="post" action="./user/addOffer" enctype="multipart/form-data">
            <%--<div class="form-group">
                <select class="selectpicker">
                    <option value="1" selected>Отдам</option>
                    <option value="2">Заберу</option>
                </select>
            </div>--%>
            <div class="form-group">
                <label for="authorName">Автор:</label>
                <input type="text" class="form-control" name="authorName" id="authorName" placeholder="Имя автора" autocomplete="off">
            </div>
            <input type="hidden" name="userID" value="${user.userid}">

            <div class="form-group">
                <label for="bookTitle">Название:</label>
                <input type="text" name="bookTitle" class="form-control" id="bookTitle" placeholder="Название книги">
            </div>
            <div class="form-group">
                <label for="bookDescription">Описание:</label>
                <textarea class="form-control" name="bookDescription" id="bookDescription" rows="5"></textarea>
            </div>
            <div class="form-group">
                <div class="fileinput fileinput-new" data-provides="fileinput">
                    <div class="fileinput-preview thumbnail" data-trigger="fileinput"
                         style="width: 200px; height: 150px;"></div>
                    <div>
                        <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span
                                class="fileinput-exists">Change</span><input id="bookThumbnail" type="file"
                                                                             name="bookThumbnail"></span>
                        <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
                    </div>
                </div>
            </div>
            <button id="submitBookAddFormButton" class="btn btn-info">Добавить</button>
        </form>
    </div>
</div>