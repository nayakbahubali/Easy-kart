package com.easykart.commonDTO;

import java.util.List;

import com.easykart.requestDTO.ProductRequestDTO;

import lombok.Data;

@Data
public class CommonDTO {

	private String message;
	private Integer status;
	private Object data;

	public CommonDTO(String message, Integer status) {
		this.message = message;
		this.status = status;
	}

	private List<ProductRequestDTO> products;

}
