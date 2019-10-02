package com.easykart.requestDTO;

import lombok.Data;

@Data
public class ProductRequestDTO {

	private Long id;

	private String product;

	private String mobileBrand;

	private String model;

	private String type;

	private Integer purchasePrice;

	private Integer sellingPrice;

	private Integer quantity;

}
