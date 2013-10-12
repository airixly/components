package com.airixly.components.login;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Airixly
 * Date: 13-10-9
 */

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("login.do")
    public
    @ResponseBody
    String login(@RequestParam String model) {
        Gson gson = new Gson();
        UserBean userModel = gson.fromJson(model, UserBean.class);
        logger.debug(userModel.getUsername());
        logger.debug(userModel.getPassword());
        userModel.setId("123456");
        return gson.toJson(userModel);
    }
}
