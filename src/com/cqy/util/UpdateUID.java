package com.cqy.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by goumin on 2019/10/24.
 */


public class UpdateUID {

    @Autowired
    private SessionFactory sessionFactory;

    public void updateUID(String userId, String name, String departID, int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(" update UserInfo set userId=?,name=?,departId=?where id =?");
            query.setParameter(0, userId);
            query.setParameter(1, name);
            query.setParameter(2, departID);
            query.setParameter(3, id);
            query.executeUpdate();
            session.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
