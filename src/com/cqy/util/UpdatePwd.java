package com.cqy.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by goumin on 2019/10/24.
 */

public class UpdatePwd {
    @Autowired
    private SessionFactory sessionFactory;

    public void updateDate(String pwd, String uid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(" update UserInfo set password=?where userId =?");
            query.setParameter(0, pwd);
            query.setParameter(1, uid);
            query.executeUpdate();
            session.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
