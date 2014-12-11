<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link href="<s:url value="/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet"/>
    <title>${pageName}</title>
</head>
<body>
<script src="<s:url value="/js/jquery-1.11.1.js" />"></script>
<script src="<s:url value="/frameworks/bootstrap/js/bootstrap.min.js" />"></script>
<div class="container">
    <div>
        <h1>Hello! Welcome to SwapYourBook1!</h1>
        <h4>Please login using this form or
            <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
                Register!
            </button>
        </h4>
    </div>
    <div class="input-group">
        <p><input type="text" name="username" placeholder="Your username"></p>
        <p><input type="password" name="password" placeholder="Your password"></p>
        <button type="button" class="btn btn-primary btn-sm">Submit</button>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
