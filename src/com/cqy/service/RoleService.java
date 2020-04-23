package com.cqy.service;

import java.util.List;


/**
 * Created by goumin on 2019/10/24.
 */


public interface RoleService {
    List getRole();

    Integer queryAccount();

    boolean editRole(String roleId, String roleName, String description);

    boolean checkRoleId(String roleId);

    boolean addRole(String roleId, String roleName, String description);

    boolean deleteRole(String roleId);
}
