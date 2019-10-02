package com.easykart.utils;

import com.easykart.commonDTO.CommonDTO;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseUtil {

	public static CommonDTO prepareResponse(String message, Integer code, Object data) {
		CommonDTO commonResponse = new CommonDTO(message, code);
		commonResponse.setMessage(message);
		commonResponse.setStatus(code);
		commonResponse.setData(data);
		return commonResponse;
	}
}
