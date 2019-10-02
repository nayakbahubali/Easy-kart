package com.easykart.utils;

import com.easykart.entity.AdminUser;
import com.easykart.entity.ProductEntity;
import com.easykart.requestDTO.AdminUserDTO;
import com.easykart.requestDTO.ProductRequestDTO;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityConventer {

	public static ProductRequestDTO productEntityToDtoConverter(ProductEntity product) {
		ProductRequestDTO productDto = new ProductRequestDTO();
		productDto.setMobileBrand(product.getMobileBrand());
		productDto.setModel(product.getModel());
		productDto.setProduct(product.getProduct());
		productDto.setPurchasePrice(product.getPurchasePrice());
		productDto.setQuantity(product.getQuantity());
		productDto.setSellingPrice(product.getSellingPrice());
		productDto.setType(product.getType());

		return productDto;

	}

	public static AdminUserDTO adminEntityToDtoConverter(AdminUser admin) {
		AdminUserDTO adminDto = new AdminUserDTO();
		adminDto.setAdminName(admin.getAdminName());
		adminDto.setConfirmPassword(admin.getPassword());
		adminDto.setPassword(admin.getPassword());
		adminDto.setEmailId(admin.getEmailId());
		adminDto.setMobileNumber(admin.getMobileNumber());

		return adminDto;

	}

}
