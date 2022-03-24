package com.example.bootsplit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bootsplit.entity.TUser;
import com.example.bootsplit.mapper.UserMapper;
import com.example.bootsplit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lintianxing
 * @since 2022-03-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TUser> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public IPage<TUser> selectUserPage(TUser user) {
        Page<TUser> userPage = new Page<>(1,3);
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TUser::getId,user.getId());
        Page<TUser> userPage1 = userMapper.selectPage(userPage, queryWrapper);


        return userPage1;
    }

    @Override
    public List<TUser> selectUserPage1() {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().isNotNull(TUser::getId);
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public TUser selectUser(String userName, String password) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TUser::getUserName, userName);
        return userMapper.selectOne(queryWrapper);

    }

    @Override
    public TUser selectUser(String userName) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TUser::getUserName, userName);
        TUser user = userMapper.selectOne(queryWrapper);
        return user;
    }

}
