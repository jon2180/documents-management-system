package com.cqy.service;

import java.util.List;

/**
 * Created by goumin on 2019/10/24.
 */

public interface GetDictService {
    List getMenu(String roleId);
    List getRoleDict();
    List getDepartDict();
    List getProfessionDict();
}
