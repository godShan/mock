package com.zbjk.creditfactory.mock.util;

import com.google.gson.GsonBuilder;
import com.zbjk.creditfactory.mock.common.constant.ResponseCode;
import com.zbjk.creditfactory.mock.dto.ResponseVo;

/**
 * 
 * @author wangye
 * @date 2017年8月7日
 */
public class ResponseUtil {

	/**
	 * 依据code构造返回结构
	 * @param <T>
	 *
	 * @param code
	 * @return
	 */
	public static <T> ResponseVo<T> buildVoByResponseCode(ResponseCode code) {
		ResponseVo<T> vo = new ResponseVo<>();
		vo.setSuccess(code.isSuccess());
		vo.setCode(code.getCode());
		vo.setMsg(code.getMsg());
		return vo;
	}

	/**
	 * 依据code和data构造返回结构
	 * 
	 * @param <T>
	 * 
	 * @param code
	 * @param data
	 * @return
	 */
	public static <T> ResponseVo<T> buildVoByResponseCode(ResponseCode code, T data) {
		return buildVo(code.isSuccess(), code.getCode(), code.getMsg(), data);
	}

	/**
	 * 自定义参数返回结构
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * @param result
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static <T> ResponseVo<T> buildVo(boolean result, Integer code, String msg, T data) {
		ResponseVo<T> vo = new ResponseVo<>();
		vo.setSuccess(result);
		vo.setCode(code);
		vo.setMsg(msg);
		vo.setData(data);
		return vo;
	}


	/**
	 * 通过响应码和参数 构造返回的json字符串
	 * 
	 * @param code
	 * @param data
	 * @return
	 */
	public static String getReturnString(ResponseCode code, Object data) {
		return new GsonBuilder().serializeNulls().setDateFormat(DateTimeUtil.TIME_FORMAT_PUBLIC).create()
				.toJson(buildVoByResponseCode(code, data));
	}

	/**
	 * 通过响应结构 构造返回的json字符串
	 * 
	 * @param dto
	 * @return
	 */
	public static String getReturnString(ResponseVo<Object> dto) {
		return new GsonBuilder().serializeNulls().setDateFormat(DateTimeUtil.TIME_FORMAT_PUBLIC).create().toJson(dto);
	}

	/**
	 * 手动设置返回内容 构造返回的json字符串
	 * 
	 * @param result
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static String getReturnString(boolean result, Integer code, String msg, Object data) {
		return new GsonBuilder().serializeNulls().setDateFormat(DateTimeUtil.TIME_FORMAT_PUBLIC).create()
				.toJson(buildVo(result, code, msg, data));
	}
}
