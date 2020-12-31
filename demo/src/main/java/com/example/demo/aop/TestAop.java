package com.example.demo.aop;

import com.example.demo.annatation.CsAsync;
import org.springframework.stereotype.Component;

@Component
public class TestAop {

    @CsAsync
    public void test(){
        System.out.println("测试aop------------------------------------------");
    }
}
