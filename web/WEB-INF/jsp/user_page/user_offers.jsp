<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script src="<s:url value="/res/js/jquery-form.js" />" type="text/javascript"></script>
<style>
    .clickableBook {
        cursor: pointer;
    }
</style>
<script type="text/javascript">

    function loadTab(e) {
        e.preventDefault();
        var $this = $(this),
                targ = $this.attr('data-target'),
                loadurl = $this.attr('href');

        $.post(loadurl, function (data) {
            $(targ).html(data);
        });

        $this.tab('show');
    }
    function prepareForWork() {
        var zoomable = $('.zoomable');
        zoomable.smoothZoom();
        zoomable.click(function (e) {
            e.stopPropagation();
        });
        $(".clickableBook").click(function (e) {
            var $this = $(this);
            var bookID = $this.find(".offerID").text();
            $(location).attr("href", "./book/editBookForm?userOfferID=" + bookID);
        });
        
        $("#openBookAddFormButton").click(function(e){
            $("#bookAddPane").collapse('toggle');
        });

        $('#authorName').autocomplete({
            serviceUrl: 'user/addOffer/authorAutocomplete',
            paramName: "requestedString",
            maxCount: 10,
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
            maxCount: 10,
            transformResult: function (response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return { value: item.tagName, data: item.id };
                    })

                };

            }
        });
        
        
    }
    $(document).ready(function () {
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
        <td>Фото</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${userOffers}">
        <tr class="clickableBook">
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