package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pojo.CartBean;
import com.pojo.ProductInfoBean;

@Component
public interface ProductInfoMapper {

	public ProductInfoBean selectById(int id);
	public CartBean selectCartById(int id);
	public List<ProductInfoBean> selectBySql(String sql);
	public int updateById(ProductInfoBean product);
	public int insertShop(ProductInfoBean product);
	public List<ProductInfoBean> selectByCommend();
	public List<ProductInfoBean> selectByClickCount();
	public List<ProductInfoBean> selectBySellCount();
	public List<ProductInfoBean> selectByName(ProductInfoBean product);
}
