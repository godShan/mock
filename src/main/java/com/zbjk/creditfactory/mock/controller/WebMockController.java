package com.zbjk.creditfactory.mock.controller;

import com.zbjk.creditfactory.mock.domain.Mock;
import com.zbjk.creditfactory.mock.dto.MockDto;
import com.zbjk.creditfactory.mock.service.IMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wys
 * @date 2018/3/21
 */
@Controller
@RequestMapping(value = "/web/mock/")
public class WebMockController {

    @Autowired
    private IMockService iMockService;

    @RequestMapping(value = "/toIndex")
    public String toIndex() {
        return "index";
    }
}
