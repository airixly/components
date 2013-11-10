requirejs.config({
    baseUrl: ".",
    paths: {
        jquery: "vendor/jquery/jquery-1.9.1",
        underscore: "vendor/underscore/underscore",
        backbone: "vendor/backbone/backbone",
        "backbone.wreqr": "vendor/backbone/backbone.wreqr",
        "backbone.babysitter": "vendor/backbone/backbone.babysitter",
        marionette: "vendor/backbone/backbone.marionette",
        text: "vendor/require/text",
        domReady: "vendor/require/domready",
        app: "app"
    },
    shim: {
        "underscore": {
            exports: "_"
        },
        "backbone": {
            deps: ["jquery", "underscore"],
            exports: "Backbone"
        },
        "marionette": {
            deps: ["backbone"],
            exports: "Backbone.Marionette"
        }
    }
});