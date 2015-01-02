<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script src="<s:url value="/res/js/jquery-form.js" />" type="text/javascript"></script>
<script type="text/javascript">
    function prepareForWork(){
        $('.zoomable').smoothZoom();
        $(".clickableBook").click(function(e){
            alert("Book ID is"+$(this).find(".bookID").text());
        });
    }
    $(document).ready( function() {
        prepareForWork();
    });
    $("#submitBookAddFormButton").click(function (e) {
        e.preventDefault();
        $("#bookAddForm").ajaxForm({
            success: function (data) {
            },
            dataType: "text"
        }).submit();
        $("#myOffersLink").trigger('click');
        prepareForWork();
    });
</script>

<h1>Отдам</h1>
<table class="table table-hover">
    <thead>
    <tr>
        <td>Название</td>
        <td>Автор</td>
        <td>Год издания</td>
        <td>Фото</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${userBooks}">
        <tr class="clickableBook">
            <td class="hidden bookID">${book.book.bookid}</td>
            <td>${book.book.title}</td>
            <td>${book.book.author}</td>
            <td>____</td>
            <td><img rel="zoom" class="zoomable" src="./book/image?imageID=${book.book.thumbnailid}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button id="openBookAddFormButton" style="margin-top: 15px; margin-bottom: 15px;" data-toggle="collapse"
        data-target="#bookAddPane"
        aria-expanded="false" aria-controls="bookAddPane"
        href="./book/addBook" id="bookAdd" type="button"
        class="btn btn-primary btn-lg active">Добавить книгу
</button>
<div class="collapse container-fluid" id="bookAddPane">
    <jsp:include page="/book/addBook"/>
</div>