<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<link href="<s:url value="/res/frameworks/smoothzoom/szoom.css" />" rel="stylesheet"/>
<script type="text/javascript" src="<s:url value="/res/frameworks/smoothzoom/szoom.js" />" type="text/javascript"></script>
<script src="<s:url value="/res/js/jquery-form.js" />" type="text/javascript"></script>

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
            <img style="max-height: 100px; max-width: 100px" rel="zoom" class="zoomable" src="./book/image?imageID=${item.imgID}">
        </div>
        <div class="description">
            <h3 style="cursor: pointer" class="title">
                <a data-toggle="modal" data-target="#bookInfoModal${count}">${item.title}</a>
            </h3>
            <div class="author">
                    ${item.author}
            </div>
            <div class="owner">
                <a href="mailto:${item.owner.email}">${item.owner.username}</a>
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

                    <div class ="row">
                        <div class = "col-md-5">
                            <img style="max-height: 200px; max-width: 100%"
                                 src="./book/image?imageID=${item.imgID}">

                            <div class="owner-item" style="margin-top: 10px">
                                <h4 class="some_text">
                                    Владелец: <a href="mailto:${item.owner.email}.">${item.owner.username}</a>
                                </h4>
                            </div>

                        </div>

                        <div class="col-md-7">
                            <h3 class="title" style="margin-top: 10px">
                                ${item.title}
                            </h3>
                            <div class="author">
                                    ${item.author}
                            </div>

                            <hr style="margin-top: 10px; margin-bottom: 5px">

                            <h4 class="text">
                                Описание книги:
                            </h4>
                            <textarea style="max-width: 100%" class="form-control" name="bookDescription" id="bookDescription" readonly>${item.comment}</textarea>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <c:set var="count" value="${count + 1}" scope="page"/>
</c:forEach>