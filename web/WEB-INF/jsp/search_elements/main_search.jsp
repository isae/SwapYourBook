<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

    <link href="<s:url value="/res/frameworks/smoothzoom/szoom.css" />" rel="stylesheet"/>
    <script type="text/javascript" src="<s:url value="/res/frameworks/smoothzoom/szoom.js" />"></script>

<script>
    $(window).load( function() {
        $('img').smoothZoom();
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
                <a href="./login">${item.title}</a>
            </h3>
            <div class="author">
                    ${item.author}
            </div>
        </div>
    </div>

    <c:set var="count" value="${count + 1}" scope="page"/>
</c:forEach>