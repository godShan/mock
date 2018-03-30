package com.zbjk.creditfactory.mock.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zbjk.creditfactory.mock.domain.Mock;
import com.zbjk.creditfactory.mock.dto.MockDto;
import com.zbjk.creditfactory.mock.dto.PageModel;
import com.zbjk.creditfactory.mock.mapper.MockMapper;
import com.zbjk.creditfactory.mock.service.IMockService;
import com.zbjk.creditfactory.mock.util.BeanCopierUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wys
 * @date 2018/3/21/021
 */
@Service("iMockService")
public class IMockServiceImpl implements IMockService {

    @Autowired
    private MockMapper mockMapper;

    @Override
    public boolean insertMock(MockDto mockDto) {
        mockDto.setCreatedAt(new Date());
        Mock mock = BeanCopierUtil.copyBean(Mock.class, mockDto);
        int result = mockMapper.insertMock(mock);
        if (result < 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public PageModel<MockDto> selectMockByUrl(MockDto mockDto) {
        PageHelper.startPage(mockDto.getPage(), mockDto.getSize());
        Mock mock = BeanCopierUtil.copyBean(Mock.class, mockDto);
        List<MockDto> mockDtoList = mockMapper.selectMockByUrl(mock);
        PageInfo<MockDto> mockDtoEnd = new PageInfo<>(mockDtoList);
        return (PageModel<MockDto>) PageModel.newPageModelWithData(mockDto.getSize(), mockDtoEnd.getTotal(),
                mockDto.getPage(), mockDtoList);
    }

    @Override
    public boolean deleteMockById(Long id) {
        Integer result = mockMapper.deleteMockById(id);
        if (result < 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean updateMockById(MockDto mockDto) {
        Mock mock = BeanCopierUtil.copyBean(Mock.class, mockDto);
        Integer result = mockMapper.updateMockById(mock);
        if (result < 1) {
            return false;
        } else {
            return true;
        }
    }
}
