<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<h1>Мои настройки</h1>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Расскажите нам о себе</h3>
    </div>
    <div class="panel-body">
        <form id="userEditForm" role="form" method="post" action="./user/editUser" enctype="multipart/form-data">
            <div class="form-group">
                <label for="userLastName">Фамилия:</label>
                <input type="text" class="form-control" name="userLastName" value="${user.lastName}"
                       id="userLastName" placeholder="Ваше имя">
            </div>
            <input type="hidden" name="userID" value="${user.userid}">

            <div class="form-group">
                <label for="userFirstName">Имя:</label>
                <input type="text" name="userFirstName" class="form-control" value="${user.firstName}" id="userFirstName"
                       placeholder="Ваша фамилия">
            </div>
            <div class="form-group">
                <label for="userEMail">Адрес электронной почты:</label>
                <input type="text" name="userEMail" class="form-control" value="${user.email}" id="userEMail"
                       placeholder="Ваша email">
            </div>
            <div class="form-group">
                <label for="userCity">Город:</label>
                <input type="text" name="userCity" class="form-control" value="${city.name}" id="userCity"
                       placeholder="Ваш город">
            </div>
            <input type="hidden" name="cityID" value="${user.cityid}">
            <div class="form-group">
                <label for="userAvatar">Аватар:</label>

                <div class="fileinput fileinput-exists" data-provides="fileinput" id="userAvatar">
                    <div class="fileinput-preview thumbnail" style="max-width: 100px">
                        <img rel="zoom" class="zoomable" src="./book/image?imageID=${user.avatarid}"/>
                    </div>
                    <div>
                        <span class="btn btn-default btn-file">
                             <span class="fileinput-exists">Изменить</span>
                            <input id="userAvatarInput"
                                   type="file"
                                   name="userAvatar"></span>
                    </div>
                </div>
            </div>
            <button id="editUserButton" class="btn btn-success">Сохранить</button>
        </form>
    </div>
</div>
<div class="panel panel-warning">
    <div class="panel-heading">
        <h3 class="panel-title">Изменить пароль</h3>
    </div>
    <div class="panel-body">
        <form id="changePasswordForm" role="form" method="post" action="./user/changePassword">
            <div class="form-group">
                <label for="oldPassword">Старый пароль:</label>
                <input type="password" id="oldPassword" name="oldPassword" placeholder="Old password">
            </div>
            <div class="form-group">
                <label for="newPassword">Новый пароль:</label>
                <input type="password" id="newPassword" name="newPassword" placeholder="New password">
            </div>
            <div class="form-group">
                <label for="passwordConfirm">Подтвердите пароль:</label>
                <input type="password" id="passwordConfirm" name="confirmPassword" placeholder="Confirm password">
            </div>
            <button id="changePasswordButton" class="btn btn-primary">Изменить пароль</button>
        </form>
    </div>
</div>
<div class="panel panel-danger">
    <div class="panel-heading">
        <h3 class="panel-title">Опасная зона</h3>
    </div>
    <div class="panel-body">
        <a class="btn btn-lg btn-danger" data-toggle="modal" data-target="#deleteModal">Удалить пользователя</a>
    </div>
</div>
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form action="./user/deleteUser" method="get">
            <div class="modal-content">
                <div class="modal-header bg-danger">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Закрыть</span></button>
                    <h4 class="modal-title" id="deleteBook">Вы уверены, что хотите удалить ваш аккаунт?</h4>
                </div>
                <div class="modal-body">В этом случае все данные о вас будут стёрты без возможности восстановления.</div>
                <div class="modal-footer">
                    <input type="submit" id="loginButton" class="btn btn-danger" value="Удалить"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </form>
    </div>
</div>