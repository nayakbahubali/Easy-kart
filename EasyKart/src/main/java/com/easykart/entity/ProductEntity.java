package com.easykart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "items")
@Data
@Where(clause = "is_active=1")
public class ProductEntity extends RecordMetaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "product")
	private String product;

	@Column(name = "mobile_brand")
	private String mobileBrand;

	@Column(name = "model")
	private String model;

	@Column(name = "type")
	private String type;

	@Column(name = "purchase_price")
	private Integer purchasePrice;

	@Column(name = "selling_price")
	private Integer sellingPrice;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "is_active")
	private Boolean isActive;

}
