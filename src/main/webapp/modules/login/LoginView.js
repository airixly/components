define([
    "jquery",
    "backbone",
    "text!./tpl/login-tpl.html",
    "assets/bootstrap/js/popover"
], function ($, Backbone, loginTpl) {
    return Backbone.View.extend({
        className: "login-panel",
        model: new (Backbone.Model.extend({
            url: "login.do"
        }))(),
        events: {
            "input .username input": "valName",
            "keyup .password input": "enter",
            "click .icons-wrapper.right": "submit"
        },
        render: function () {
            this.$el.append(loginTpl);
            return this;
        },
        valName: function () {
            var $target = this.$(".username input"),
                username = $target.val(), regex = /[^a-zA-Z0-9@._]/,
                $userIcon = this.$(".username div.icons-wrapper");
            if (!username || regex.test(username)) {
                $userIcon.css("background", "#d2322d")
                    .find("i.icon-user-1").hide()
                    .siblings(".icon-attention-circled").show();
                $target.popover({
                    content: "Username is invalid!",
                    trigger: "manual"
                });
                $target.popover("show");
                return false;
            } else if ($userIcon.find("i.icon-attention-circled").is(":visible")) {
                $userIcon.css("background", "#e0e0e0")
                    .find("i.icon-attention-circled").hide()
                    .siblings(".icon-user-1").show();
                if ($target.siblings(".popover").length !== 0) {
                    $target.popover("hide");
                }
            }
            this.model.set("username", username);
            return true;
        },
        valPassword: function () {
            var password = this.$(".password input").val(),
                $submitIcon = this.$(".icons-wrapper.right");
            if (password.length === 0) {
                $submitIcon.popover({
                    content: "Password can't be empty!",
                    trigger: "manual"
                });
                $submitIcon.popover("show");
                return false;
            } else if ($submitIcon.siblings(".popover").length !== 0) {
                $submitIcon.popover("hide");
            }
            this.model.set("password", password);
            return true;
        },
        enter: function (e) {
            if (e && e.which !== 13) {
                return;
            }
            this.submit();
        },
        submit: function () {
            var self = this, options;
            if (!this.valName() || !this.valPassword()) {
                return;
            }
            self.$("i.icon-right").hide().siblings(".icon-spinner").show();
            options = {
                success: function (data) {
                    self.$("input").attr("disabled", "disabled");
                    window.location.href = "index.jsp?id=" + data.id;
                },
                error: function (model, resp) {
                    self.$("i.icon-spinner").hide().siblings(".icon-right").show();
                }
            };
            this.model.save(null, options);
        }
    });
});