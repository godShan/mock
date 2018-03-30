package com.zbjk.creditfactory.mock.service;

import com.zbjk.creditfactory.mock.domain.Mock;
import com.zbjk.creditfactory.mock.dto.MockDto;
import com.zbjk.creditfactory.mock.dto.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author wys
 *@date 2018/3/21
 *@description
 */
public interface IMockService {

    /**
     * 新增
     * @param mockDto
     * @return
     */
    boolean insertMock(@Param("mock") MockDto mockDto);

    /**
     * 查询
     * @param mockDto
     * @return
     */
    PageModel<MockDto> selectMockByUrl(@Param("mock") MockDto mockDto);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteMockById(@Param("id") Long id);

    /**
     * 根据ID来修改
     * @param mockDto
     * @return
     */
    boolean updateMockById(@Param("mock") MockDto mockDto);
}
