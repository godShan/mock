package com.zbjk.creditfactory.mock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangye
 * @date 2018/3/27
 * @description
 */
@Controller
public class BaseController {

    @RequestMapping(value = {"","/"})
    public String toIndex() {
        return "index";
    }

}
