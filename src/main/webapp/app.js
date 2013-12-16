define([
    "backbone",
    "marionette",
    "./modules/header/index"
], function (Backbone, Marionette, Header) {
    var App = new Marionette.Application();
    App.addRegions({
        header: "#header",
        main: "#main",
        footer: "#footer"
    });
    App.addInitializer(function () {
        App.header.show(new Header());
    });
    App.on("initialize:after", function () {
        Backbone.history.start();
    });
    return App;
});