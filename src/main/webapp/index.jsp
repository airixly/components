<html>
<meta>
<title></title>
<script src="./vendor/require/require.js"></script>
<script src="./main.js"></script>
<body>
<div>
    <h3>Login info:<%=request.getParameter("id")%>
    </h3>
</div>
<script>
    require([
        "domReady!",
        "jquery",
        "backbone",
        "app"
    ], function (doc, $, Backbone, app) {
        $(function () {
            //global settings
            Backbone.emulateHTTP = true;
            Backbone.emulateJSON = true;

            //init all components
            app.initApp();
        });
    });
</script>
</body>
</html>
