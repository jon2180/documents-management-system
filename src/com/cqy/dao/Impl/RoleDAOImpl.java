package com.cqy.dao.Impl;

import com.cqy.dao.RoleDAO;
import com.cqy.entity.UserRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by goumin on 2019/10/24.
 */
@Repository
@Transactional
@Scope("prototype")
public class RoleDAOImpl implements RoleDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getRole() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from UserRole ");
            List menuList = query.list();
            return menuList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean editRole(String roleId, String roleName, String description) {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setRolename(roleName);
            userRole.setDescription(description);
            userRole.setCss("layui-badge layui-bg-orange");
            session.merge(userRole);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkRoleId(String roleId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from UserRole where roleId=?");
            query.setParameter(0, roleId);
            List list = query.list();
            if (list.size() == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addRole(String roleId, String roleName, String description) {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setRolename(roleName);
            userRole.setDescription(description);
            userRole.setCss("layui-badge layui-bg-orange");
            session.save(userRole);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteRole(String roleId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String[] role = roleId.split(",");
            for (int i = 0; i < role.length; i++) {
                Query query = session.createQuery("delete from UserRole where id=?");
                query.setParameter(0, role[i]);
                query.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
