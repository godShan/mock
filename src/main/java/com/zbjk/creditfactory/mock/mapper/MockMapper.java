package com.zbjk.creditfactory.mock.mapper;

import com.zbjk.creditfactory.mock.domain.Mock;
import com.zbjk.creditfactory.mock.dto.MockDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * MockMapper数据库操作接口类
 * @author wys
 **/

public interface MockMapper{

	/**
	 * 新增
	 * @param mock
	 * @return
	 */
	int insertMock(@Param("mock") Mock mock);

	/**
	 * 查询
	 * @param mock
	 * @return
	 */
	List<MockDto> selectMockByUrl(@Param("mock") Mock mock);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteMockById(@Param("id") Long id);

	/**
	 * 根据ID来修改
	 * @param mock
	 * @return
	 */
	int updateMockById(@Param("mock") Mock mock);

}