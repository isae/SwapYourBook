<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<link href="<s:url value="/res/frameworks/smoothzoom/szoom.css" />" rel="stylesheet"/>
<script type="text/javascript" src="<s:url value="/res/frameworks/smoothzoom/szoom.js" />"></script>

<script>
    $(document).ready( function() {
        var zoomable = $('.zoomable');
        zoomable.smoothZoom();
        zoomable.click(function (e) {
            e.stopPropagation();
        });
    });
</script>

<c:set var="count" value="0" scope="page" />

<c:forEach var="item" items="${bookItems}">
    <div class ="search-item ${count}">
        <div class = "s-image">
            <img rel="zoom" class="zoomable" src="./book/image?imageID=${item.imgID}">
        </div>
        <div class="description">
            <h3 class="title">
                <a data-toggle="modal" data-target="#bookInfoModal${count}">${item.title}</a>
            </h3>
            <div class="author">
                    ${item.author}
            </div>
        </div>
    </div>

    <div class="modal fade" id="bookInfoModal${count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                            class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Информация о книге</h4>
                </div>
                <div class="modal-body">

                    <div class ="book-info">
                        <div class = "s-image">
                            <img style="max-height: 100%; max-width: 100%"
                                 src="./book/image?imageID=${item.imgID}">
                        </div>
                        <div class="description">
                            <h3 class="title">
                                ${item.title}
                            </h3>
                            <div class="author">
                                    ${item.author}
                            </div>
                        </div>
                    </div>

                    <hr style="margin-top: 80px; margin-bottom: 20px">

                    <h4 class="text">
                        Пользователи, у которых есть эта книга:
                    </h4>

                    <c:forEach var="owner" items="${item.owners}">
                        <div class="owner-item">
                            <div class="owner-name">
                                <a href="./user">${owner}</a>
                            </div>
                            <div class="owner-send-message">
                                <button type="button" class="btn btn-primary" onclick="alert('You cannot do that yet!');">Написать этому пользователю</button>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>

    <c:set var="count" value="${count + 1}" scope="page"/>
</c:forEach>