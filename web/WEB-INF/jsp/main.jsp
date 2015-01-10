<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%--<link href="<s:url value="/css/style.css"/>" rel="stylesheet" />--%>

    <link href="<s:url value="/res/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
    <script src="<s:url value="/res/js/jquery-1.11.1.js" />" type="text/javascript"></script>
    <script src="<s:url value="/res/js/jquery.autocomplete.js" />"></script>
    <script src="<s:url value="/res/frameworks/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>

    <link href="<s:url value="/res/css/style.css" />" rel="stylesheet" type="text/css"/>
    <link href="<s:url value="/res/css/autocomplete-style.css" />" rel="stylesheet" type="text/css"/>
    <link href="<s:url value="/res/css/search-item-style.css" />" rel="stylesheet" type="text/css"/>
    <script src="<s:url value="/res/frameworks/notifyjs/notify.min.js" />" type="text/javascript"></script>
    <script src="<s:url value="/res/js/registration.js" />" type="text/javascript"></script>

    <script>
        function searchForItems() {
            var requestedString = $("#search").val();
            var isByAuthor = $("#by_a").prop('checked');

            $.ajax({
                type: 'POST',
                async: false,
                url: "main/search",
                data: {
                    requestedString: requestedString,
                    isByAuthor: isByAuthor
                },

                success: function (data) {
                    $("#search-result").html(data);
                }
            });
        }

        $(document).ready(function () {
            $('#search').autocomplete({
                serviceUrl: 'main/autocomplete',
                paramName: "requestedString",
                delimiter: ",",
                minChars: 3,
                deferRequestBy: 200,
                maxHeight: 400,
                transformResult: function (response) {

                    return {
                        //must convert json to javascript object before process
                        suggestions: $.map($.parseJSON(response), function (item) {
                            return { value: item.tagName, data: item.id };
                        })

                    };

                }

            });
            $("#registrationSubmitButton").click(function (e) {
                tryToSendData();
            });
        });
    </script>

    <title>Welcome! Happy book sharing!</title>
</head>
<body>
<div class="container">
    <header class="navbar navbar-static-top" id="top" role="banner">
        <div class="container " style="background-color: lightblue; position: absolute;">
            <div class="navbar-header">
                <a href="./main" class="navbar-brand" style="color:#ffffff;"><b>SwapYourBook</b></a>
            </div>
            <div style="position:absolute; right: 1%; top:20%;">
                <c:choose>
                    <c:when test="${user eq null}">
                        <button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#registrationModal">
                            Регистрация
                        </button>
                        <button class="btn btn-sm btn-default" data-toggle="modal" data-target="#signInModal">
                            Войти
                        </button>
                    </c:when>
                    <c:otherwise>
                        <div style="display: inline-block; font-size: 18px"><span class="label label-default">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                ${user.username}</span></div>
                        <form style="display: inline-block" action="./logout_user" method="post">
                            <input type="submit" class="btn btn-sm btn-default" value="Выйти"/>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </header>
    <div class="row">
        <div class="wrapper_search-block" id="search-block">

            <div class="wrapper_search-block__search" id="search_div">
                <div class="search-form__form">
                    <div class="search-form search-form__row_1" id="pre-filters">
                        <label for="include_authors">
                            <input type="checkbox" name="by_authors" id="by_a"
                                   class="form-input-checkbox">
                            искать по авторам
                        </label>
                    </div>

                    <div class="search-form search-form__row_2">
                        <input onKeyDown="if(event.keyCode == 13) searchForItems();" type="text" name="q"
                               placeholder="Ищу книгу..." id="search"/>
                        <button class="btn btn-info" onclick="searchForItems();">Найти</button>
                    </div>
                </div>

                <div class="search_result" id="search-result"></div>

            </div>
        </div>

    </div>
</div>

<%--<footer>
    <div class="container " id="footer">
        <div id="footer-content">
            <a href="/"><img src="<s:url value="/res/images/deyneka.jpg"/>" alt="Deyneka already here" height="50" width=auto></a>
            <p>Copyright © 2014 Deynekology.</p>
        </div>
    </div>
</footer>--%>
<div class="modal fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="regModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Закрыть</span></button>
                <h4 class="modal-title" id="regModalLabel">Регистрация</h4>
            </div>
            <div class="modal-body">
                <div class="input-group">
                    <div class="container">
                        <p><input type="text" id="reg_username" name="username" placeholder="Your username"></p>

                        <p><input type="email" id="reg_email" name="username" placeholder="Your email"></p>

                        <p><input type="password" id="reg_passwd" name="password" placeholder="Your password"></p>

                        <p><input type="password" id="reg_confirm" name="confirm_password"
                                  placeholder="Please, confirm password"></p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="registrationSubmitButton">Отправить</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="signInModal" tabindex="-1" role="dialog" aria-labelledby="signInModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form action="./login_user" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Закрыть</span></button>
                    <h4 class="modal-title" id="signInModalLabel">Войти</h4>
                </div>
                <div class="modal-body">
                    <div class="input-group">
                        <p><input type="text" id="loginUsername" name="username" placeholder="Your username"></p>

                        <p><input type="password" name="password" id="loginPassword" placeholder="Your password"></p>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" id="loginButton" class="btn btn-primary" value="Войти"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
