package com.easykart.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easykart.commonDTO.CommonDTO;
import com.easykart.requestDTO.ProductRequestDTO;
import com.easykart.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping()
	public CommonDTO addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		log.info("addProduct in ProductController");
		return productService.addProduct(productRequestDTO);
	}

	@GetMapping
	public CommonDTO allProducts(@RequestParam(required = true, defaultValue = "10") Integer count,
			@RequestParam(required = true, defaultValue = "1") Integer page) {
		log.info("allproduct in ProductController");
		return productService.getAllProducts(count, page);
	}

	@DeleteMapping
	public CommonDTO deleteProduct(@RequestParam(required = true) Long id) {
		log.info("deleteProduct in ProductController");
		return productService.deleteProduct(id);
	}
}
