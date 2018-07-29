package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.mapper.ProductInfoMapper;
import com.pojo.CartBean;
import com.pojo.ProductInfoBean;

@Repository
public class ProductInfoDao {

	@Autowired
	private ProductInfoMapper productInfoMapper;

	public ProductInfoBean selectById(int id){
		return productInfoMapper.selectById(id);
	}
	
	public CartBean selectCartById(int id){
		return productInfoMapper.selectCartById(id);
	}
	
	public List<ProductInfoBean> selectBySql(String map){
		return productInfoMapper.selectBySql(map);
	}
	
	public int updateById(ProductInfoBean product){
		return productInfoMapper.updateById(product);
	}
	
	public int insertShop(ProductInfoBean product){
		return productInfoMapper.insertShop(product);
	}
	
	public List<ProductInfoBean> selectByCommend(){
		return productInfoMapper.selectByCommend();
	}
	
	public List<ProductInfoBean> selectByClickCount(){
		return productInfoMapper.selectByClickCount();
	}
	
	public List<ProductInfoBean> selectBySellCount(){
		return productInfoMapper.selectBySellCount();
	}
	
	public List<ProductInfoBean> selectByName(ProductInfoBean product){
		return productInfoMapper.selectByName(product);
	}
}
