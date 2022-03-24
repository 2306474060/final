package com.example.bootsplit;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.bootsplit.entity.TUser;
import com.example.bootsplit.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootTest
class BootsplitApplicationTests {

    @Autowired
    private IUserService userService;
    @Test
    void contextLoads() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/split?characterEncoding=UTF-8&serverTimezone=GMT%2B8&rewriteBatchedStatements=true", "root", "1234")
                .globalConfig(builder -> {
                    builder.author("lintianxing") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C://Users/86173/Desktop/bootsplit"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapper, "C://Users/86173/Desktop/bootsplit/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    @Test
    public void t1(){
        TUser user= TUser.builder().id(1).build();
        Page<TUser> userPage = (Page<TUser>) userService.selectUserPage(user);
        System.out.print("---------------------------------"+userPage.toString());
    }

    @Test
    public void t2(){
        PageHelper.startPage(1,2);
        TUser byId = userService.getById(1);
        ArrayList<TUser> users = new ArrayList<>();
        users.add(byId);
        PageInfo<TUser> pageInfo = new PageInfo<>(users);
        System.out.print("---------------------------------"+pageInfo);
    }

}
