<%--
  Created by IntelliJ IDEA.
  User: cowld
  Date: 2022-10-15
  Time: 오후 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<form id="loginForm" action="/auth/login">
    이메일<input type="text" name="email">
    비밀번호<input type="password" name="password">
</form>
<a id="login" href="/auth/login">가입</a>


<script>
    $(document).ready(function () {
        var form = $("#loginForm")

        $("#login").on("click", function (e) {

            e.preventDefault();

            var member = {
                "email" : form.find("input[name='email']").val(),
                "password" : form.find("input[name='password']").val()
            };

            function add(member, callback, error){
                $.ajax({
                    type : "post",
                    url : "/auth/login",
                    data : JSON.stringify(member),
                    contentType : "application/json; charset=UTF-8",
                    success: function (result, status, xhr) {
                        if (callback) {
                            callback(result);
                        }
                    },
                    error: function (xhr, status, er) {
                        if (error) {
                            error(er);
                        }
                    }
                })
            }

            add(member, function (result) {
                localStorage.setItem("token",result.grantType + " " + result.accessToken)
                self.location = "/auth/main";
            });
        });

    });
</script>
</body>
</html>
