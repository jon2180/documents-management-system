package com.cqy.dao;

import java.util.List;

/**
 * Created by goumin on 2019/10/24.
 */

public interface NoticeDAO {
    List getNotice(String roleId,String departId);
    boolean editNotice(Integer id,String roleId,String content,String departId);
    boolean addNotice(String roleId,String content,String departId);
    boolean  deleteNotice(Integer id);
    boolean updateNotice(String userId);
}
