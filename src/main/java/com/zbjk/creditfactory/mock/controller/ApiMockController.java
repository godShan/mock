package com.zbjk.creditfactory.mock.controller;

import com.zbjk.creditfactory.mock.common.constant.ResponseCode;
import com.zbjk.creditfactory.mock.dto.MockDto;
import com.zbjk.creditfactory.mock.dto.PageModel;
import com.zbjk.creditfactory.mock.dto.ResponseVo;
import com.zbjk.creditfactory.mock.service.IMockService;
import com.zbjk.creditfactory.mock.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wys
 * @date 2018/3/21
 */
@Controller
@RequestMapping(value = "/api/mock/")
public class ApiMockController {

    @Autowired
    private IMockService iMockService;

    @PostMapping(value = "/queryMockByDto", consumes="application/json")
    @ResponseBody
    public ResponseVo queryMockByDto(@RequestBody MockDto mockDto) {
        PageModel<MockDto> mockDtoPageModel = iMockService.selectMockByUrl(mockDto);
        return ResponseUtil.buildVo(true, ResponseCode.CODE_SUCCESS.getCode(), ResponseCode.CODE_SUCCESS.getMsg(), mockDtoPageModel);
    }

    @PostMapping(value = "/insertMockByDto", consumes="application/json")
    @ResponseBody
    public ResponseVo insertMockByDto(@RequestBody MockDto mockDto) {
        boolean result = iMockService.insertMock(mockDto);
        if (result) {
            return ResponseUtil.buildVo(true, ResponseCode.CODE_SUCCESS.getCode(), ResponseCode.CODE_SUCCESS.getMsg(), null);
        } else {
            return ResponseUtil.buildVo(false, ResponseCode.CODE_ERROR.getCode(), ResponseCode.CODE_ERROR.getMsg(), null);
        }
    }

    @PostMapping(value = "/updateMockByDto", consumes="application/json")
    @ResponseBody
    public ResponseVo updateMockByDto(@RequestBody MockDto mockDto) {
        boolean result = iMockService.updateMockById(mockDto);
        if (result) {
            return ResponseUtil.buildVo(true, ResponseCode.CODE_SUCCESS.getCode(), ResponseCode.CODE_SUCCESS.getMsg(), null);
        } else {
            return ResponseUtil.buildVo(false, ResponseCode.CODE_ERROR.getCode(), ResponseCode.CODE_ERROR.getMsg(), null);
        }
    }

    @PostMapping(value = "/deleteMockByDto", consumes="application/json")
    @ResponseBody
    public ResponseVo deleteMockByDto(@RequestBody MockDto mockDto) {
        boolean result = iMockService.deleteMockById(mockDto.getId());
        if (result) {
            return ResponseUtil.buildVo(true, ResponseCode.CODE_SUCCESS.getCode(), ResponseCode.CODE_SUCCESS.getMsg(), null);
        } else {
            return ResponseUtil.buildVo(false, ResponseCode.CODE_ERROR.getCode(), ResponseCode.CODE_ERROR.getMsg(), null);
        }
    }
}
