package com.airixly.components.login;

import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Airixly
 * Date: 13-10-9
 */
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String model = request.getParameter("model");
        Gson gson = new Gson();
        UserBean userModel = gson.fromJson(model, UserBean.class);
        System.out.println("username --- " + userModel.getUsername());
        System.out.println("password --- " + userModel.getPassword());
        userModel.setId("123456");
        String message = gson.toJson(userModel);
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.write(message);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
