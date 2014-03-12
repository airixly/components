define([
    "jquery",
    "backbone",
    "text!./tpl/login-tpl.html",
    "assets/bootstrap/js/popover"
], function ($, Backbone, loginTpl) {
    return Backbone.View.extend({
        className: "login-panel",
        model: new (Backbone.Model.extend({
            url: "loginAuth.do"
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
                this.showPopover($target, "Username is invalid!");
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
                this.showPopover($submitIcon, "Password can't be empty!");
                return false;
            } else if ($submitIcon.siblings(".popover").length !== 0) {
                $submitIcon.popover("hide");
            }
            this.model.set("password", password);
            return true;
        },
        showPopover: function ($target, content) {
            $target.popover({
                content: content,
                trigger: "manual"
            });
            $target.popover("show");
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
            this.showEdit(false);
            options = {
                success: function () {
                    self.$(".login-form").submit();
                },
                error: function (model, resp) {
                    self.handleErrorMessage(resp.responseText);
                }
            };
            this.model.save(null, options);
        },
        showEdit: function (isArrow) {
            var $icon = $(isArrow ? ".icon-arrows-cw" : ".icon-right");
            $icon.hide().siblings("i").show();
        },
        handleErrorMessage: function (message) {
            switch (message) {
                case "err-0":
                    this.showPopover(this.$(".username input"), "Username doesn't exist!");
                    break;
                case "err-1":
                    this.showPopover(this.$(".icons-wrapper.right"), "Password is wrong!");
                    break;
                default:
                    console.log(message);
            }
            this.showEdit(true);
        }
    });
});
