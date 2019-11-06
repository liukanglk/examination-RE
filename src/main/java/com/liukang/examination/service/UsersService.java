package com.liukang.examination.service;

import com.liukang.examination.entity.Users;

import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @Description users的service层
 * @Date 2019/10/29 11:00
 */
public interface UsersService {
    //查询所有用户
    List<Users> userList();

//    查询单个用户
    List<Users> findUser(String username);

    //新增用户
    int addUser(Map<String, String> map);

    //更新密码
    int updatePassword(Map<String, String> map);


}
