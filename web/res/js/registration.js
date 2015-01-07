/**
 * Created by root on 1/7/15.
 */


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
    if (!checkEmail(reg_email)) {
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