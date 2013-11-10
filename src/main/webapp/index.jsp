<html>
<meta>
<title></title>
<script src="./vendor/require/require.js"></script>
<script src="./main.js"></script>
<body>
<div>
    <h3>Login info:id--<%=request.getParameter("id")%>&name--<%=request.getParameter("name")%>
    </h3>

    <div id="header"></div>
    <div id="main"></div>
    <div id="footer"></div>
</div>
<script id="layout-template" type="text/template">
    <section>
        <navigation id="menu">Menu&nbsp;Test</navigation>
        <article id="content">Content&nbsp;Test</article>
    </section>
</script>
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
            app.start();
        });
    });
</script>
</body>
</html>
