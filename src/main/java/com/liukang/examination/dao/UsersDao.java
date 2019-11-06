package com.liukang.examination.dao;

import com.liukang.examination.entity.Users;

import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @Description dao层
 * @Date 2019/10/29 9:38
 */
public interface UsersDao {

    // 查找数据库中所有用户
    public List<Users> findAll();

    //    查找数据库中某个用户
    public List<Users> findUser(String username);

    // 新增用户


    public int addUser(Map<String, String> map);

    //更新密码
    public int updatePassword(Map<String, String> map);
}
