define([
    "jquery",
    "./LoginView"
], function ($, LoginView) {
    return {
        init: function () {
            var loginView = new LoginView();
            $("#content").append(loginView.render().$el);
        }
    };
});