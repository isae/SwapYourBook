<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%--<link href="<s:url value="/css/style.css"/>" rel="stylesheet" />--%>

        <link href="<s:url value="/res/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
        <script src="<s:url value="/res/js/jquery-1.11.1.js" />" type="text/javascript"></script>
        <%--<script src="<s:url value="/res/js/jquery-ui.js" />" type="text/javascript"></script>--%>
        <script src="<s:url value="/res/js/jquery.autocomplete.js" />"></script>
        <script src="<s:url value="/res/frameworks/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>

        <link href="<s:url value="/res/css/style.css" />" rel="stylesheet" type="text/css" />
        <link href="<s:url value="/res/css/autocomplete-style.css" />" rel="stylesheet" type="text/css" />
        <link href="<s:url value="/res/css/search-item-style.css" />" rel="stylesheet" type="text/css" />

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

                    success: function(data) {
                        $("#search-result").html(data);
                    }
                });
            }

            $(document).ready(function() {

                $('#search').autocomplete({
                    serviceUrl: 'main/autocomplete',
                    paramName: "requestedString",
                    delimiter: ",",
                    // max_length: 30,
                    transformResult: function(response) {

                        return {
                            //must convert json to javascript object before process
                            suggestions: $.map($.parseJSON(response), function(item) {
                                return { value: item.tagName, data: item.id };
                            })

                        };

                    }

                });

            });

        </script>

    <title>Welcome! Happy book sharing!</title>
</head>
<body>
    <div class="main-wrapper" id="wrapper">
        <div class="container " style="background-color: lightblue" id="header">
            <div class="navbar-header">
                <a href=".." class="navbar-brand" id="logo" style="color:#ffffff;"><b>SwapYourBook</b></a>
            </div>

            <nav>
                <a href="./login">войти</a> |
                <a href="./index">регистрация</a>
            </nav>

        </div>

        <div class="wrapper_search-block" id="search-block">

            <div class="wrapper_search-block__search" id="search_div">
                <div  class="search-form__form">
                    <div class="search-form search-form__row_1" id="pre-filters">
                        <label for="include_authors">
                            <input type="checkbox" name="by_authors" id="by_a" class="form-input-checkbox">
                            искать по авторам
                        </label>
                    </div>

                    <div class="search-form search-form__row_2">
                        <input onKeyDown="if(event.keyCode == 13) searchForItems();" type="text" name="q" placeholder="Ищу книгу..." id="search"/>
                        <button onclick="searchForItems();">Найти</button>
                    </div>
                </div>

                <div class="search_result" id="search-result"> </div>

            </div>
        </div>

    </div>

    <footer>
        <div class="container " id="footer">
            <div id="footer-content">
                <a href="/"><img src="<s:url value="/res/images/deyneka.jpg"/>" alt="Deyneka already here" height="50" width=auto></a>
                <p>Copyright © 2014 Deynekology.</p>
            </div>
        </div>
    </footer>
</body>
</html>
