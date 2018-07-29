package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pojo.ProductCategory;

@Component
public interface ProductCategoryMapper {

	public List<ProductCategory> selectAll();
	public int insertCategory(ProductCategory category);
}
