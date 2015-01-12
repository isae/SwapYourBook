<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

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
            <td class="hidden userWishID">${book.userwishid}</td>
            <td>
                <div class="bookTitle">${book.title}</div>
            </td>
            <td>
                <div class="bookAuthor">${book.author}</div>
            </td>
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
<div class="modal fade" id="editUserWishModal" tabindex="-1" role="dialog" aria-labelledby="editUserWishModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form action="./user/editUserWish" method="post" id="editUserWishForm">
            <div class="modal-content">
                <div class="modal-header bg-info">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Закрыть</span></button>
                    <h4 class="modal-title" id="editUserWish">Редактировать</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="userWishID" id="userWishID">
                    <div class="form-group">
                    <label for="formAuthorName">Автор:</label>
                    <input type="text" id="formAuthorName" name="authorName">
                </div>
                <div class="form-group">
                    <label for="formBookTitle">Название:</label>
                    <input type="text" id="formBookTitle" name="bookTitle" >
                </div>
                </div>
                <div class="modal-footer">
                    <button id="editUserWishModalSubmitButton" type="button" class="btn btn-primary" data-dismiss="modal">Сохранить</button>
                    <button id="deleteUserWishButton" type="button" class="btn btn-danger" data-dismiss="modal">Удалить</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </form>
    </div>
</div>