<html>
<meta>
<title></title>
<script src="vendor/require/require.js"></script>
<script src="./main.js"></script>
<body>
<script>
    require([
        "domReady!",
        "jquery",
        "app"
    ], function (doc, $, app) {
        $(function () {
            app.initApp();
        });
    });
</script>
</body>
</html>
