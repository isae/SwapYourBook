<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
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
        function checkEmail(email) {
            var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
            return filter.test(email);
        }
        function tryToSendData() {
            var reg_username = $("#reg_username").val();
            var reg_email = $("#reg_email").val();
            var reg_passwd = $("#reg_passwd").val();
            var reg_confirm = $("#reg_confirm").val();

            var usernameAvailable;
            var success = true;
            if (!(reg_username && reg_email && reg_passwd && reg_confirm)) {
                $.notify("Please, fill all the fields", "error");
                return false;
            }
            if (reg_username.length >= 6) {
                $.ajax({
                    type: 'POST',
                    async: false,
                    url: "login/checkUsernameAvailable",
                    data: {
                        username: reg_username
                    },
                    success: function (msg) {
                        usernameAvailable = JSON.parse(msg.toLowerCase());
                    }
                });
                if (usernameAvailable != true) {
                    $("#reg_username").notify("User with this username already exists", {position: "right"}, "error");
                    success = false;
                }
            } else {
                success = false;
                $("#reg_username").notify("Username must be at least 6 characters", {position: "right"}, "error");
            }
            if(!checkEmail(reg_email)){
                success = false;
                $("#reg_email").notify("Invalid email", {position: "right"}, "error");
            }
            if (reg_passwd != reg_confirm) {
                success = false;
                $("#reg_confirm").notify("Passwords does not match!", {position: "right"}, "error");
            }
            if (success) {
                $.ajax({
                    type: 'POST',
                    async: false,
                    url: "login/sendAuthToken",
                    data: {
                        email: reg_email,
                        username: reg_username,
                        password: reg_passwd
                    },
                    success: function (msg) {
                        $.notify("Registration completed! Please, check your e-mail folder for confirmation letter", "info");
                    }
                });
            }
            return success;
        }
    </script>
    <title>${pageName}</title>
</head>
<body>
<div id="unique" class="container">
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

<div class="modal fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
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
