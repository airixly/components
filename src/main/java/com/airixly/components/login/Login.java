package com.airixly.components.login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

/**
 * User: Lyanxi
 * Date: 13-10-9
 */
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html");
        try {
            PrintWriter pw = response.getWriter();
            pw.println("resp");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
