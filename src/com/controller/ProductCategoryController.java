package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.ProductCategory;
import com.service.ProductCategoryService;

@Controller
public class ProductCategoryController {

	private static Logger log = LoggerFactory.getLogger(ProductCategoryController.class);
	@Autowired
	private ProductCategoryService productCategoryService;
	
	/**
	 * 查询所有商品类信息.
	 */
	@RequestMapping("/show")
	public ModelAndView selectAll(){
		ModelAndView view = new ModelAndView();
		List<ProductCategory> list = productCategoryService.selectAll();
		view.addObject("list", list);
		view.setViewName("/page/admin/category.jsp");
		log.debug("show response:"+list);
		return view;
	}
	
	@RequestMapping("/addcategory")
	public String addCategory(@ModelAttribute("category") ProductCategory category){
		
		int i = productCategoryService.insertCategory(category);
		if (i > 0){
			return "/page/success.jsp";
		}
		return "/page/error.jsp";
	}
	
	@RequestMapping("/categoryall")
	@ResponseBody
	public Map<String,Object> getAll(){
		Map<String,Object> param = new HashMap<String, Object>();
		List<ProductCategory> list = productCategoryService.selectAll();
		param.put("list", list);
		log.debug("categoryall response:"+param);
		return param;
	}
	
}
