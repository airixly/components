define([
    "jquery",
    "backbone",
    "text!./tpl/login-tpl.html"
], function ($, Backbone, loginTpl) {
    return Backbone.View.extend({
        className: "login-panel",
        events: {
            "input .username input": "verify",
            "input .password input": "submit",
            "click .icon-right": "submit"
        },
        render: function () {
            this.$el.append(loginTpl);
            return this;
        },
        verify: function (e) {
            var self = this, $target = $(e.currentTarget), name = $target.val(),
                regex = /[^a-zA-Z0-9@._]/;
            if (regex.test(name)) {
                this.$(".username .icon-wrapper").css("background", "#d2322d")
                    .find("i").removeClass("icon-user-1").addClass("icon-attention-circled");
                setTimeout(function () {
                    self.$(".username .icon-wrapper").css("background", "#e0e0e0")
                        .find("i").removeClass("icon-attention-circled").addClass("icon-user-1");
                }, 1000);
            }
        },
        submit: function (e) {
            var $target = $(e.currentTarget), password = $target.val();
            this.$(".password .right i").removeClass("icon-right").addClass("icon-spin4 animate-spin");
        }
    });
});