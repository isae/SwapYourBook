<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(document).ready(function () {
        $("#addUserWishFormButton").click(function(e){
            $("#bookWishAddPane").collapse('toggle');
        });

        $("#submitBookWishAddFormButton").click(function (e) {
            e.preventDefault();
            $("#bookWishAddForm").ajaxForm({
                async: false,
                success: function (data) {
                    $("#myWishesLink").trigger("click");
                },
                dataType: "text"
            }).submit();
        })

    });
</script>

<h1>Заберу</h1>
<table class="table table-hover">
    <thead>
    <tr>
        <td>Название</td>
        <td>Автор</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${wishes}">
        <tr class="clickableBook">
            <td>${book.title}</td>
            <td>${book.author}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button id="addUserWishFormButton" style="margin-top: 15px; margin-bottom: 15px;" data-toggle="collapse"
        data-target="#bookWishAddPane"
        aria-expanded="false" aria-controls="bookWishAddPane"
        href="./book/addBookWishForm" type="button"
        class="btn btn-primary btn-lg active">Добавить книгу
</button>
<div class="collapse container-fluid" id="bookWishAddPane">
    <jsp:include page="/book/addBookWishForm"/>
</div>