package com.baomidou.mybatisplus.samples.generator.system.service.impl;

import com.baomidou.mybatisplus.samples.generator.system.entity.User;
import com.baomidou.mybatisplus.samples.generator.system.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.generator.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lintianxing
 * @since 2022-03-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
