package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductInfoDao;
import com.pojo.CartBean;
import com.pojo.ProductInfoBean;

@Service
public class ProductInfoService {

	private static Logger log = LoggerFactory.getLogger(ProductInfoService.class);
	@Autowired
	private ProductInfoDao productInfoDao;
	
	public CartBean selectCartById(int id){
		return productInfoDao.selectCartById(id);
	}
	public ProductInfoBean selectById(int id){
		return productInfoDao.selectById(id);
	}
	
	public List<ProductInfoBean> selectBySql(String map){
		log.debug("map="+map);
		return productInfoDao.selectBySql(map);
	}
	
	public int updateById(ProductInfoBean product){
		return productInfoDao.updateById(product);
	}
	
	public int insertShop(ProductInfoBean product){
		return productInfoDao.insertShop(product);
	}
	
	/**
	 * 
	 * @return 查询左侧热销商品、推荐商品、人气商品.
	 */
	public Map<String,Object> selectLeft(){
		Map<String,Object> param = new HashMap<String, Object>();
		List<ProductInfoBean> sells = productInfoDao.selectBySellCount();
		List<ProductInfoBean> popularity = productInfoDao.selectByClickCount();
		List<ProductInfoBean> recommend = productInfoDao.selectByCommend();
		param.put("sells", sells);
		param.put("popularity", popularity);
		param.put("recommend", recommend);
		return param;
	}
	
	/**
	 * 根据商品名称查询商品信息.
	 * @param name 商品名
	 * @return	商品信息
	 */
	public Map<String,Object> searchInfo(ProductInfoBean product){
		List<ProductInfoBean> list = productInfoDao.selectByName(product);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("list", list);
		return param;
	}
}
