package com.Kotori.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    /***
     * 当没有异常发生的时候，执行的顺序为
     * Around的前置, Before, 目标方法, Around的后置, After, AfterReturning
     *
     * 当有异常发生的时候，执行的顺序为
     * Around的前置, Before, 目标方法(异常发生), After, AfterThrowing
     *
     * http://127.0.0.1:8080/personTest
     */
    @RequestMapping("/personTest")
    @ResponseBody
    public String personTest() {
        System.out.println("do something-----------------------------");
        //int i=1/0; // Exception
        return "personTest";
    }
}
