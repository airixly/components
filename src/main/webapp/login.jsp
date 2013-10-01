<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title></title>
    <link rel="stylesheet" href="assets/login.css">
    <script type="text/javascript" src="vendor/require/require.js"></script>
    <script type="text/javascript" src="./main.js"></script>
</head>
<body>
<div id="content">
    <form role="form">
        <div class="form-group">
            <div id="username">
                <div class="icon-wrapper left">
                    <i class="icon-user-1"></i>
                </div>
                <input type="text" class="form-control" placeholder="Username"/>
            </div>
        </div>
        <div class="form-group">
            <div id="password">
                <div class="icon-wrapper left">
                    <i class="icon-key"></i>
                </div>
                <input type="password" class="form-control" placeholder="Password"/>

                <div class="icon-wrapper right">
                    <i class="icon-right"></i>
                </div>
            </div>
        </div>
    </form>
</div>
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