package com.battcn.controller;

import com.battcn.entity.User;
import com.battcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author faming.yang@hand-china.com 2022-10-07 17:56
 */
@RestController
@RequestMapping("/my-users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public int addUser() {
        // 添加用户
        return userService.insertUser();
    }
}
