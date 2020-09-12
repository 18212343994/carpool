<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>
<div class="register-container container">
    <div class="row">
        <div class="span3"></div>
        <div class="register span6">
            <form action="login" method="post">
                <h2>登录管理系统</h2>
                <span class="label label-important"><%= request.getAttribute("msg") == null ? "" : request.getAttribute("msg") %></span>
                <label for="username">用户名</label>
                <input type="text" id="username" name="username" placeholder="请填写用户名...">
                <label for="password">密码</label>
                <input type="text" id="password" name="password" placeholder="请输入密码6 ~ 16位...">
                <button type="submit">登录</button>
                <br/><br/><br/>
                <a href="#">忘记密码</a>
                &nbsp;/&nbsp;
                <a href="register.html">新用户注册</a>
            </form>
        </div>
        <div class="span3"></div>
    </div>
</div>

<!-- Javascript -->
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>

</body>

</html>
