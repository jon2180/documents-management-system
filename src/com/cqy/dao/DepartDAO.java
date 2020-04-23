package com.cqy.dao;

import java.util.List;

/**
 * Created by goumin on 2019/10/24.
 */
public interface DepartDAO {
    List getDepart();

    boolean checkDepartId(String departmentId);

    boolean addDepart(String departmentId, String departmentName);

    boolean editDepart(String departmentId, String departmentName);

    boolean checkDepart(String departmentId);

    boolean deleteDepart(String departmentId);
}
