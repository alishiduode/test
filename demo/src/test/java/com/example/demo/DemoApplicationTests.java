package com.example.demo;

import com.example.demo.aop.TestAop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    TestAop testAop;

    @Test
    void contextLoads() {
        testAop.test();
        System.out.println("执行了-----------------------------------------");
    }

}
