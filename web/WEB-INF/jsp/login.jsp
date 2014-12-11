<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <link href="<s:url value="/res/frameworks/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
    <script src="<s:url value="/res/js/jquery-1.11.1.js" />" type="text/javascript"></script>
    <script src="<s:url value="/res/frameworks/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<s:url value="/res/frameworks/notifyjs/notify.min.js" />" type="text/javascript"></script>
    <script>
        function checkPasswdEquality() {
            var result = $("#reg_passwd").val() === $("#reg_confirm").val();
            alert(result);
            return result;
        }
        function tryToSendData(){
            var usernameAvailable;
            $.ajax({
                type: 'POST',
                url: "login/checkUsernameAvailable",
                data: {
                    username: $("#reg_username").val()
                },
                success: function(msg){
                    usernameAvailable = msg;
                }
            });
            if(!usernameAvailable){
                $("#reg_username").notify(
                        { position:"right" },"User with this username already exists");
                return;
            }
            var pass_match = $("#reg_passwd").val() === $("#reg_confirm").val();
            if(!pass_match){
                $("#reg_confirm").notify("Passwords does not match!", "error");
            }
        }
    </script>
    <title>${pageName}</title>
</head>
<body>
<div id ="unique" class="container">
    <div>
        <h1>Hello! Welcome to SwapYourBook!</h1>
        <h4>Please login using this form or
            <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#registrationModal">
                Register!
            </button>
        </h4>
    </div>
    <div class="input-group">
        <p><input type="text" name="username" placeholder="Your username"></p>

        <p><input type="password" name="password" placeholder="Your password"></p>
        <button type="button" class="btn btn-primary btn-sm">Login</button>
    </div>
</div>

<div class="modal fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Registration</h4>
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
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="tryToSendData()">Submit</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
