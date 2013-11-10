define([
    "marionette",
    "./modules/header/index"
], function (Marionette, Header) {
    var App = new Marionette.Application();
    App.addRegions({
        header: "#header",
        main: "#main",
        footer: "#footer"
    });
    App.addInitializer(function () {
        App.header.show(new Header());
    });
    return App;
});