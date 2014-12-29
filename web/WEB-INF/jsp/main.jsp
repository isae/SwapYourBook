
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
                var requestedString = $("#query").val();

                $.ajax({
                    type: 'POST',
                    async: false,
                    url: "main/searchRequestedString",
                    data: {
                        reqString: requestedString
                    },
                    success: function (msg) {
                        alert("LOGGING | requested string: " + msg + " submitted");
                    }
                });
            }

            $(function() {
                $('#query').autocomplete({
                    serviceUrl: 'main/autocomplete',
                    paramName: "requestedString",
                    delimiter: ",",
                    transformResult: function(response) {

                        return {
                            // alert("LOGGING | got response!");
                            //must convert json to javascript object before process
                            // suggestions: $.map($.parseJSON(response), function(item) {
                            //     alert("LOGGING | got response!");
                            //     return { value: item.toString() };
                            ///})

                        };

                    }

                });

                var availableTags = [
                    "ActionScript",
                    "AppleScript",
                    "Asp",
                    "BASIC",
                    "C",
                    "C++",
                    "Clojure",
                    "COBOL",
                    "ColdFusion",
                    "Erlang",
                    "Fortran",
                    "Groovy",
                    "Haskell",
                    "Java",
                    "JavaScript",
                    "Lisp",
                    "Perl",
                    "PHP",
                    "Python",
                    "Ruby",
                    "Scala",
                    "Scheme"
                ];
                $('#querying').autocomplete({
                    // source: "main/autocomplete",
                    // source: 'main/autocomplete', // Страница для обработки запросов автозаполнения
                    //minChars: 2, // Минимальная длина запроса для срабатывания автозаполнения
                    // delimiter: /(,|;)\s*/, // Разделитель для нескольких запросов, символ или регулярное выражение
                    // maxHeight: 400, // Максимальная высота списка подсказок, в пикселях
                    // width: 300, // Ширина списка
                    // zIndex: 9999, // z-index списка
                    // deferRequestBy: 200, // Задержка запроса (мсек), на случай, если мы не хотим слать миллион запросов, пока пользователь печатает. Я обычно ставлю 300.
                    // params: { request: $("#query").val() }, // Дополнительные параметры

                    // It seems to work properly without special callback function
                    // onSelect: function(data, value){ }, // Callback функция, срабатывающая на выбор одного из предложенных вариантов,
                    //lookup: ['WarAndPiece', 'Onegin', 'LetMyPeopleGo'] // Список вариантов для локального автозаполнения
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



            <div class="wrapper_search-block__search" id="search">

                <form class="search-form__form" action="#" method="get">

                    <div class="search-form__row search-form__row_1">

                        <input type="text" name="q" placeholder="Search" id="query"/>
                        <button type="submit" onclick="search()" >GO</button>

                    </div>



                    <div class="search-form__row search-form__row_2   " id="pre-filters">

                        <label for="include_authors">
                            <input type="checkbox" name="include_author" id="a" class="form-input-checkbox">
                            искать по авторам тоже
                        </label>

                        <label for="with_images">
                            <input type="checkbox" name="with_images" id="i" class="form-input-checkbox">
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
