define([
    "marionette"
], function (Marionette) {
    var headerLayout = Marionette.Layout.extend({
        template: "#layout-template",
        regions: {
            menu: "#menu",
            content: "#content"
        }
    });
    return headerLayout;
});