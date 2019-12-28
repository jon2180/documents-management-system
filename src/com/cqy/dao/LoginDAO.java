package com.cqy.dao;

import java.util.List;
import com.cqy.entity.*;

/**
 * Created by goumin on 2019/10/24.
 */
public interface LoginDAO {
    boolean add(Object o);

    boolean delete(Object o);

    boolean update(Object o);

    List find(Object o);

    UserInfo checkLogin(String uid,String pwd);

    UserDepartment getDepartment(String departId);

    UserRole getRole(String roleId);

    UserProfession getProfession(String professionId);

    Notice getNotice(String roleId,String departId);

    Integer getAccount(String roleId,String departId);

    boolean setLastLoginTime(Integer id);
}
