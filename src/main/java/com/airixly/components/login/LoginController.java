package com.airixly.components.login;

import com.airixly.entity.UserInfo;
import com.airixly.utils.HibernateUtil;
import com.google.gson.Gson;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: Airixly
 * Date: 13-10-9
 */

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login.do")
    public
    @ResponseBody
    String login(@RequestParam String model) {
        //parse request model
        Gson gson = new Gson();
        UserInfo user = gson.fromJson(model, UserInfo.class);

        //get the record from database
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from UserInfo where username='" + user.getUsername() + "'";
        Query query = session.createQuery(hql);
        List results = query.list();

        //check if user is valid
        String message = "{}";
        if (results.size() > 0) {
            UserInfo result = (UserInfo) results.get(0);
            if (user.getPassword().equals(result.getPassword())) {
                message = gson.toJson(result);
            }
        }
        session.close();
        return message;
    }
}
