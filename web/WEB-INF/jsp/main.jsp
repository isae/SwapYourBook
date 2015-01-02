
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%--<link href="<s:url value="/css/style.css"/>" rel="stylesheet" />--%>

        <link href="<s:url value="/res/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
        <script src="<s:url value="/res/js/jquery-1.11.1.js" />" type="text/javascript"></script>
        <%--<script src="<s:url value="/res/js/jquery-ui.js" />" type="text/javascript"></script>--%>
        <script src="<s:url value="/res/js/jquery.autocomplete.js" />"></script>
        <script src="<s:url value="/res/frameworks/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>

        <link href="<s:url value="/res/css/style.css" />" rel="stylesheet" type="text/css" />

        <script>
            function search() {
                var requestedString = $("#search").val();
                var isByAuthors = $("#by_a").attr('checked');
                var isWithImages = $("#with_i").attr('checked');


                $.ajax({
                    type: 'POST',
                    async: false,
                    url: "main/search",
                    data: {
                        requestedString: requestedString,
                        isByAuthors: isByAuthors,
                        isWithImages: isWithImages
                    },

                    success: function(response) {

                        return {
                            //must convert json to javascript object before process
                            suggestions: $.map($.parseJSON(response), function(item) {
                                alert("DETKA: " + item);
                                // return { value: item.tagName, data: item.id };
                            })

                        };

                    }
                });
            }

            $(document).ready(function() {

                $('#search').autocomplete({
                    serviceUrl: 'main/autocomplete',
                    paramName: "requestedString",
                    delimiter: ",",
                    max_length: 10,
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
    <div class="main-wapper" id="wrapper">
        <div class="wrapper__header" id="header">
            <a href="/"><img src="<s:url value="/res/images/deyneka.jpg"/>" alt="Deyneka was here" height="100" width="200" id="logo-image"></a>

            <nav>
                <a href="/SwapYourBook/login/">login</a> |
                <a href="/SwapYourBook/index/">Create new account</a>
            </nav>

        </div>

        <div class="wrapper_search-block" id="search-block">

            <div class="wrapper_search-block__greeting-title" id="greeting-title">
                <h1>Find some books</h1>
            </div>



            <div class="wrapper_search-block__search" id="search_div">

                <form class="search-form__form" action="#" method="get">

                    <div class="search-form__row search-form__row_1">

                        <input type="text" name="q" placeholder="Search" id="search"/>
                        <button type="submit" onclick="search()" >GO</button>

                    </div>



                    <div class="search-form__row search-form__row_2   " id="pre-filters">

                        <label for="include_authors">
                            <input type="checkbox" name="by_authors" id="by_a" class="form-input-checkbox">
                            искать по авторам
                        </label>

                        <label for="with_images">
                            <input type="checkbox" name="with_images" id="with_i" class="form-input-checkbox">
                            только с фото
                        </label>

                    </div>

                </form>

            </div>
        </div>

    </div>

    <footer>
        <div id="footer">
            <div id="footer-logo">
                <a href="/"><img src="<s:url value="/res/images/deyneka.jpg"/>" alt="Deyneka already here" height="50" width="100"></a>
                <p>Copyright © 2014 Deynekology.</p>
            </div>
        </div>
    </footer>
</body>
</html>
