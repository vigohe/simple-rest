package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vigohe on 31-07-16.
 */
@RestController
public class SimpleController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String simpleHello(){
        return "Hello, World!";
    }

}
