package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductCategoryDao;
import com.pojo.ProductCategory;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	public List<ProductCategory> selectAll(){
		return productCategoryDao.selectAll();
		
	}
	
	public int insertCategory(ProductCategory category){
		return productCategoryDao.insertCategory(category);
	}
}
