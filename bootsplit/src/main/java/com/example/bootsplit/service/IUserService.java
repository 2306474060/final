package com.example.bootsplit.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bootsplit.entity.TUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lintianxing
 * @since 2022-03-15
 */
public interface IUserService extends IService<TUser> {

    public IPage<TUser> selectUserPage(TUser user);

    public List<TUser> selectUserPage1();

    public TUser selectUser(String userName, String password);

    public TUser selectUser(String userName);


}
