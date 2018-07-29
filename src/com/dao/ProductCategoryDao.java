package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.mapper.ProductCategoryMapper;
import com.pojo.ProductCategory;


@Repository
public class ProductCategoryDao {

	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	
	public List<ProductCategory> selectAll(){
		return productCategoryMapper.selectAll();
	}
	
	public int insertCategory(ProductCategory category){
		return productCategoryMapper.insertCategory(category);
	}
}
