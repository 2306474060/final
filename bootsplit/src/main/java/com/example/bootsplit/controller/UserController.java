package com.example.bootsplit.controller;

import com.example.bootsplit.entity.TUser;
import com.example.bootsplit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lintianxing
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public List<TUser> get(){
        return userService.selectUserPage1();
    }


    @GetMapping("/{{name}}")
    //可以指定多个身份，普通用户不能进入管理员界面。
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin(String name){
        return "hello,admin";
    }
}
