<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<s:url value="/res/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
    <link href="<s:url value="/res/frameworks/bootstrap/css/bootstrap-theme.min.css" />" rel="stylesheet"
          type="text/css"/>
    <script src="<s:url value="/res/js/jquery-1.11.1.js" />" type="text/javascript"></script>
    <script src="<s:url value="/res/frameworks/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
    <link href="<s:url value="/res/frameworks/smoothzoom/szoom.css" />" rel="stylesheet"/>
    <script type="text/javascript" src="<s:url value="/res/frameworks/smoothzoom/szoom.js" />"></script>
    <script type="text/javascript">
        function loadTab(e){
            e.preventDefault();
            var $this = $(this),
                    targ = $this.attr('data-target'),
                    loadurl = $this.attr('href');

            $.post(loadurl, function (data) {
                $(targ).html(data);
            });

            $this.tab('show');
        }
        $(document).ready ( function () {
            $(document).on ("click", "#myMenu a", loadTab);
            $("#myBooksLink").trigger('click');
            $("#bookAdd").click(loadTab);
        });
    </script>
    <title>User Page</title></head>
<body>
<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
    <div class="container" style="background-color: lightblue">
        <div class="navbar-header">
            <a href=".." class="navbar-brand" style="color:#ffffff;"><b>SwapYourBook</b></a>
        </div>
    </div>
</header>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <img style="width: 100%; padding-bottom: 5px;margin-bottom: 10px;"
                 src="<s:url value="/res/images/deyneka.jpg"/>" class="img-thumbnail">
            <ul class="nav nav-pills nav-stacked" role="tablist" id="myMenu">
                <li role="presentation" class="active">
                    <a id="myBooksLink" data-target="#books" href="./user/myBooks">Мои книги</a>
                </li>
                <li role="presentation">
                    <a data-target="#wishes" href="./user/myWishes">
                        <span>Заберу</span>
                    <span style="float: right; color: green;" class="glyphicon glyphicon-import"
                          aria-hidden="true"></span>
                    </a>
                </li>
                <li role="presentation">
                    <a data-target="#offers" href="./user/myOffers">
                        <span>Отдам</span>
                    <span style="float: right; color: red;" class="glyphicon glyphicon-export"
                          aria-hidden="true"></span>
                    </a>
                </li>
                <li role="presentation">
                    <a data-target="#saved" href="./user/mySaved">Сохранённые</a>
                </li>
                <li role="presentation">
                    <a data-target="#settings" href="./user/mySettings">Настройки</a>
                </li>
            </ul>
            <button style="margin-top: 15px" data-target="#bookAddPane" href="./book/addBook" id="bookAdd" type="button" class="btn btn-primary btn-lg active">Добавить книгу</button>
        </div>
        <div class="col-md-10">
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="books"></div>
                <div role="tabpanel" class="tab-pane fade" id="wishes"></div>
                <div role="tabpanel" class="tab-pane fade" id="offers"></div>
                <div role="tabpanel" class="tab-pane fade" id="saved"></div>
                <div role="tabpanel" class="tab-pane fade" id="settings"></div>
                <div role="tabpanel" class="tab-pane fade" id="bookAddPane"></div>
            </div>
            <!--Body content-->
        </div>
    </div>
</div>
</body>
</html>