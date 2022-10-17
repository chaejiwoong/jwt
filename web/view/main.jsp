<%--
  Created by IntelliJ IDEA.
  User: cowld
  Date: 2022-10-15
  Time: 오후 7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
    <h1>메인 페이지</h1>
    <a href="/auth/login">로그인</a>
    <a href="/auth/signup">회원가입</a>
    <a id="mypage" href="/member/mypage">마이페이지</a>

    <script>
        $(document).ready(function () {

            let token = localStorage.getItem('token');

            $("#mypage").on("click", function (e) {

                // var xhr = new XMLHttpRequest();
                //
                // xhr.open("get","/member/mypage")
                //
                // xhr.setRequestHeader("Authorization",token);
                // xhr.send();


                e.preventDefault();

                function add(callback, error){

                    $.ajax({
                        type : "get",
                        url : "/member/mypage",
                        headers : {
                            "Authorization" :  token
                        },
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
                add(function (result) {
                    alert(result);
                }, function (er) {
                    alert(er);
                });
            });
        });
    </script>
</body>
</html>
