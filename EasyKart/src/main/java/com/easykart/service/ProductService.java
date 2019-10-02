package com.easykart.service;

import com.easykart.commonDTO.CommonDTO;
import com.easykart.requestDTO.ProductRequestDTO;

public interface ProductService {

	public CommonDTO addProduct(ProductRequestDTO productRequestDTO);

	public CommonDTO getAllProducts(Integer count, Integer page);

	public CommonDTO deleteProduct(Long id);

}
