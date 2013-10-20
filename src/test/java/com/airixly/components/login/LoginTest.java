package com.airixly.components.login;


import com.airixly.entity.UserInfo;
import com.airixly.utils.HibernateUtil;
import com.google.gson.Gson;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * User: Airixly
 * Date: 13-10-20
 */
public class LoginTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from UserInfo where username='test'";
        Query query = session.createQuery(hql);
        List results = query.list();
        if (results.size() > 0) {
            UserInfo user = (UserInfo) results.get(0);
            Gson gson = new Gson();
            System.out.println(gson.toJson(user));
            System.out.println("User's type is " + user.getType());
        }
    }
}
