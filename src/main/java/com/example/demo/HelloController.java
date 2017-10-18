package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 菜小川 on 2017/10/17.
 */
@RestController
public class HelloController {
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String index(){
        return "hello springboot";
    }
}
