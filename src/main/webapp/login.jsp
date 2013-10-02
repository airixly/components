<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="assets/login.css">
    <script type="text/javascript" src="vendor/require/require.js"></script>
    <script type="text/javascript" src="./main.js"></script>
</head>
<body>
<div id="content"></div>
<script>
    require([
        "jquery",
        "modules/login/index"
    ], function ($, login) {
        $(function () {
            login.init();
        });
    });
</script>
</body>
</html>