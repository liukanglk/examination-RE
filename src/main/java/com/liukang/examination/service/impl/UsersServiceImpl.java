package com.liukang.examination.service.impl;

import com.liukang.examination.dao.UsersDao;
import com.liukang.examination.entity.Users;
import com.liukang.examination.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @Description
 * @Date 2019/10/29 11:01
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;


    @Override
    public List<Users> userList() {
        return usersDao.findAll();
    }

    @Override
    public List<Users> findUser(String username) {
        return usersDao.findUser(username);
    }

    @Override
    public int addUser(Map<String, String> map) {
        return usersDao.addUser(map);
    }

    @Override
    public int updatePassword(Map<String, String> map) {
        return usersDao.updatePassword(map);
    }


}
