<%--
 Copyright 2004-2005 Sun Microsystems, Inc.  All rights reserved.
 Use is subject to license terms.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link href="<s:url value="/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet"/>
    <title>Hello</title>
</head>
<body bgcolor="white">
<img src="<s:url value="/images/duke.gif"/>"/>

<h1>Hello, SERVER IS RUNNING</h1>
<script src="<s:url value="/js/jquery-1.11.1.js" />"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<s:url value="/frameworks/bootstrap/js/bootstrap.min.js" />"></script>
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Click! If you`re a fag, then fочшancy modal window must appear!
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
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
