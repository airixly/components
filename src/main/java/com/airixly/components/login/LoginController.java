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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * User: Airixly
 * Date: 13-10-9
 */

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/loginAuth.do")
    public void loginAuth(HttpServletRequest request, HttpServletResponse response) {
        //parse request model
        Gson gson = new Gson();
        UserInfo user = gson.fromJson(request.getParameter("model"), UserInfo.class);

        //get the record from database
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from UserInfo where username='" + user.getUsername() + "'";
        Query query = session.createQuery(hql);

        //check if user is valid
        String message = null;
        try {
            List results = query.list();
            if (results.size() > 0) {
                UserInfo result = (UserInfo) results.get(0);
                if (user.getPassword().equals(result.getPassword())) {
                    Cookie cookie = new Cookie("uid", result.getId());
                    cookie.setMaxAge(1800);
                    response.addCookie(cookie);
                    message = gson.toJson(result);
                } else {
                    //password is wrong
                    message = "err-1";
                }
            } else {
                //username doesn't exist
                message = "err-0";
            }
            session.close();
        } catch (Exception ex) {
            message = ex.getMessage().toString();
        }
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.print(message);
    }

    @RequestMapping("/login.do")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
