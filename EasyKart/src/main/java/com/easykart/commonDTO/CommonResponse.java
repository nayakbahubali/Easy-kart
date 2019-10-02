package com.easykart.commonDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class CommonResponse {

	private String message;
	private Integer status;
	private Object data;

	public CommonResponse(String message,Integer status){
		this.message=message;
		this.status=status;
	}

}
