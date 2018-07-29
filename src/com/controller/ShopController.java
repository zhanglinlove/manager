package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.db.DB;
import com.pojo.CartBean;
import com.pojo.ProductInfoBean;
import com.service.ProductInfoService;

@Controller
public class ShopController {

	private static Logger log = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	private ProductInfoService productInfoService;
	
	@RequestMapping("/modifyshop")
	public ModelAndView modifyShop(@RequestParam(value="id") int id){
		log.debug("id="+id);
		ModelAndView view = new ModelAndView();
		ProductInfoBean info = productInfoService.selectById(id);
		view.addObject("info", info);
		view.setViewName("/page/admin/modifyshop.jsp");
		return view;
	}
	
	@RequestMapping("/updateshop")
	public String updateInfo(@ModelAttribute("product") ProductInfoBean product){
		
		if (product != null){
			productInfoService.updateById(product);
		}
		return "/page/admin/selectShop.jsp";
	}
	
	@RequestMapping("/addshop")
	public String addShop(@ModelAttribute("product") ProductInfoBean product){
		int i = productInfoService.insertShop(product);
		if (i > 0){
			return "/page/success.jsp";
		}
		return "/page/error.jsp";
	}
	
	@RequestMapping("/sellselect")
	@ResponseBody
	public Map<String, Object> sellselect(HttpServletRequest request){
		Map<String, Object> param = new HashMap<String, Object>();
		param = productInfoService.selectLeft();
		Cookie[] cooks = request.getCookies();
		String str = null;
		if (cooks != null){
			for(Cookie c : cooks){
				if ("username".equals(c.getName()))
					str = c.getValue();
			}
		}
		List<CartBean> list = null;
		if (str != null){
			list = (List<CartBean>) request.getSession().getAttribute(str+"cart");
		}
		param.put("cart", list);
		return param;
	}
	
	@RequestMapping("/searchInfo")
	@ResponseBody
	public Map<String, Object> searchInfo(@ModelAttribute("product") ProductInfoBean product){
		Map<String, Object> param = new HashMap<String, Object>();
		param = productInfoService.searchInfo(product);
		return param;
	}
	
	/*@RequestMapping("/addCart")
	public String addCart(@RequestParam("id") int id,
			HttpServletRequest request,HttpServletResponse response){
		CartBean info = productInfoService.selectCartById(id);
		Cookie[] cook = request.getCookies();
		if (cook != null){
			String value = null;
			for(Cookie c : cook){
				if ("username".equals(c.getName())){
					value = c.getValue();
					break;
				}	
			}
			if (value != null){
				String cart = value + "cart";
				List<CartBean> list = new ArrayList<CartBean>();
				list.add(info);
				request.getSession().setAttribute(cart, list);
				return "add success";
			} else {
				return "/page/userLogin.jsp";
			}
			
		} else {
			return "/page/userLogin.jsp";
		}
		
	}*/
	
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> test(@RequestParam(value="sql") String sql){
		log.debug("id="+sql);
		Map<String, Object> map = new HashMap<String, Object>();
		DB db = new DB();
		List<Object> info = db.select(sql,null);
		map.put("info", info);
		log.debug("response info="+map);
		return map;
	}
	
	@RequestMapping("/addCartInfo")
	@ResponseBody
	public Map<String, Object> addCartInfo(@RequestBody ProductInfoBean productInfoBean,
			HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> param = new HashMap<String, Object>();
		int id = productInfoBean.getId();
		ProductInfoBean product = productInfoService.selectById(id);
		CartBean c1 = new CartBean();
		c1.setId(product.getId());
		c1.setName(product.getName());
		c1.setPrice(product.getSellprice());
		c1.setNum(1);
		if (product != null){
			Cookie[] cooks = request.getCookies();
			String flag = null;
			for (Cookie c : cooks){
				if ("cart".equals(c.getName()))
					flag = c.getValue();
			}
			List<CartBean> list = new ArrayList<CartBean>();
			if (flag != null){
				list = (List<CartBean>) request.getSession().getAttribute(flag);
				Iterator<CartBean> it = list.iterator();
				while (it.hasNext()){
					CartBean info = it.next();
					if (id == info.getId()){
						info.setNum(info.getNum() + 1);
					}
				}
				request.getSession().setAttribute(flag, list);
			} else {
				flag = id + "cart";
				list.add(c1);
				request.getSession().setAttribute(flag, list);
				Cookie c = new Cookie("cart", flag);
				response.addCookie(c);
			}
			param.put("cart", list);
		}
		
		log.debug("addCartInfo response:"+param);
		return param;
	}
	
	@RequestMapping("/deleteCartInfo")
	@ResponseBody
	public Map<String, Object> deleteCartInfo(@RequestParam("id") int id,
			HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> param = new HashMap<String, Object>();
		ProductInfoBean product = productInfoService.selectById(id);
		Cookie[] cook = request.getCookies();
		String flag = null;
		for (Cookie c : cook){
			if ("cart".equals(c.getName()))
				flag = c.getValue();
		}
		List<CartBean> list = (List<CartBean>) request.getSession().getAttribute(flag);
		Iterator<CartBean> it = list.iterator();
		while (it.hasNext()){
			CartBean cart = it.next();
			if (product.getId() == cart.getId()){
				if (cart.getNum() <= 1){
					it.remove();
				} else {
					cart.setNum(cart.getNum() - 1);
				}	
			}
		}
		request.getSession().setAttribute(flag, list);
		param.put("list", list);
		return param;
	}
	
}
