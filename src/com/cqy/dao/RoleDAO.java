package com.cqy.dao;

import java.util.List;

/**
 * Created by goumin on 2019/10/24.
 */

public interface RoleDAO {
    List getRole();

    boolean editRole(String roleId, String roleName, String description);

    boolean checkRoleId(String roleId);

    boolean addRole(String roleId, String roleName, String description);

    boolean deleteRole(String roleId);
}
