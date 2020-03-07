package com.itheima;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class pptTest {

    @Autowired
    private com.itheima.service.pptService pptService;

    @Test
    public void test(){
        pptService.generatePptReport();
        System.out.println();
    }

}
