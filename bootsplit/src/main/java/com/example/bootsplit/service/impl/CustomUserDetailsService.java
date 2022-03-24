package com.example.bootsplit.service.impl;

import com.example.bootsplit.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 需新建配置类注册一个指定的加密方式Bean，或在下一步Security配置类中注册指定
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //通过用户名从数据库获取用户信息
        TUser user = userService.selectUser(userName);
        if (user == null){
            throw new UsernameNotFoundException("用户不存在");
        }

        //得到用户角色
        String role = user.getRole();

        //角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        //角色必须以'ROLE_'开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role));



        return new User(
                user.getUserName(),
                //因为数据库密码是明文，所以这里加密
                this.passwordEncoder.encode(user.getPassword()),
                authorities
        );
    }
}
