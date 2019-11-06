package com.liukang.examination.web.login;

import com.liukang.examination.entity.Users;
import com.liukang.examination.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liukang
 * @Description
 * @Date 2019/10/29 13:42
 */
@Controller
@RequestMapping(value = "/login")
public class UsersController {
    @Autowired
    private UsersService usersService;

    //    获取所有用户数据
    @RequestMapping(value = "/userslist", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> usersList() {
        List<Users> users;
        Map<String, Object> modelMap = new HashMap<>();
        try {
            users = usersService.userList();
            modelMap.put("rows", users);
            modelMap.put("totals", users.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errorMsg", e.toString());
        }
        return modelMap;
    }

    //    获取所有用户数据
    @RequestMapping(value = "/finduser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findUser(String username) {
        List<Users> users;
        Map<String, Object> modelMap = new HashMap<>();
        try {
            users = usersService.findUser(username);
            modelMap.put("rows", users);
            modelMap.put("totals", users.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errorMsg", e.toString());
        }
        return modelMap;
    }


    //    新增用户
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addUser(Users user) {
        Map<String, String> userMap = new HashMap<>();
        Map<String, Object> modelMap = new HashMap<>();


        try {
            userMap.put("userName", user.getUsername());
            userMap.put("password", user.getPassword());
            int isSuccess = usersService.addUser(userMap);
            modelMap.put("success", isSuccess);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errorMsg", e.toString());
        }
        return modelMap;
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateUser(Users user) {
        Map<String, String> userMap = new HashMap<>();
        Map<String, Object> modelMap = new HashMap<>();
        try {
            userMap.put("userName", user.getUsername());
            userMap.put("password", user.getPassword());
            int isSuccess = usersService.updatePassword(userMap);
            modelMap.put("success", isSuccess);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errorMsg", e.toString());
        }
        return modelMap;
    }


}
