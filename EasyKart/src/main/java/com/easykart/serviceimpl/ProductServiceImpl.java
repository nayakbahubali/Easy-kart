package com.easykart.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.easykart.commonDTO.CommonDTO;
import com.easykart.entity.ProductEntity;
import com.easykart.exceptions.EasyKartException;
import com.easykart.repository.ProductRepository;
import com.easykart.requestDTO.ProductRequestDTO;
import com.easykart.service.ProductService;
import com.easykart.utils.EntityConventer;
import com.easykart.utils.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public CommonDTO addProduct(ProductRequestDTO productRequestDTO) {
		log.info(" addProduct of productServiceImpl");
		ProductEntity productEntity = new ProductEntity();
		try {
			Integer totalQuantity = 0;

			ProductEntity product = productRepository.findByModel(productRequestDTO.getModel());
			if (product != null) {
				Integer quantity = product.getQuantity();
				totalQuantity = quantity + productRequestDTO.getQuantity();
				product.setQuantity(totalQuantity);
				product.setIsActive(true);
				productRepository.save(product);
			} else {
				BeanUtils.copyProperties(productRequestDTO, productEntity);
				productEntity.setIsActive(true);
				productRepository.save(productEntity);
			}
		} catch (Exception e) {
			log.error("Exception while saving product..");
			throw new EasyKartException("Please contact to admin!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseUtil.prepareResponse("Product added successfully..", HttpStatus.OK.value(), null);
	}

	@Override
	public CommonDTO deleteProduct(Long id) {
		log.info(" deleteById of productServiceImpl");
		ProductEntity product = productRepository.findById(id)
				.orElseThrow(() -> new EasyKartException("product id not exists.", HttpStatus.NOT_FOUND));
		if (Objects.nonNull(product)) {
			product.setIsActive(false);
			productRepository.save(product);
		}
		return ResponseUtil.prepareResponse("product deactivated successfully.", HttpStatus.OK.value(), null);
	}

	@Override
	public CommonDTO getAllProducts(Integer pageSize, Integer pageNumber) {
		log.info("getAllProducts in productServiceImpl");
		Page<ProductEntity> productEntities = productRepository.findAll(PageRequest.of(pageNumber - 1, pageSize));
		Long count = productRepository.count();
		List<ProductRequestDTO> users = productEntities.stream()
				.map(user -> EntityConventer.productEntityToDtoConverter(user)).collect(Collectors.toList());
		Map<String, Object> data = new HashMap<>();
		data.put("Products", users);
		data.put("totalSize", count);
		return ResponseUtil.prepareResponse("Product fetched successfully", HttpStatus.OK.value(), data);
	}

}
