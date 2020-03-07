package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.pptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 卧槽，给了包名 报错，！！不知啥情况
 *
 * */
@Controller
public class MybatisController {

    @Autowired
    private pptService pptService;

    @RequestMapping("/ppt")
    @ResponseBody
    public void queryUserList(){
        pptService.generatePptReport();
//        return null;
    }

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryUserList3(){
        List<User> users = userMapper.queryUserList();
        return users;
    }

}
