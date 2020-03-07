package com.wu.controller;

import com.wu.domain.User;
import com.wu.mapper.UserMapper;
import com.wu.service.pptService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Data
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

//    @Autowired
//    private UserMapper userMapper;
//
//    @RequestMapping("/query")
//    @ResponseBody
//    public List<User> queryUserList(){
//        List<User> users = userMapper.queryUserList();
//        return users;
//    }

}
