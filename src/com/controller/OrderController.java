package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.CartBean;
import com.pojo.UserBean;

@Controller
public class OrderController {

	private static Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping("/assembleOrder")
	@ResponseBody
	public Map<String,Object> assembleOrder(HttpServletRequest request){
		Map<String,Object> param = new HashMap<String, Object>();
		String[] id = request.getParameterValues("id");
		Cookie[] cooks = request.getCookies();
		String flag = null;
		String uFlag = null;
		for(Cookie cook : cooks){
			if ("cart".equals(cook.getName()))
				flag = cook.getValue();
			if ("username".equals(cook.getName()))
				uFlag = cook.getValue();
		}
		if (flag != null){
			List<CartBean> newList = new ArrayList<CartBean>();
			List<CartBean> list = (List<CartBean>) request.getSession().getAttribute(flag);
			Iterator<CartBean> it = list.iterator();
			while(it.hasNext()){
				CartBean car = it.next();
				for(String s : id){
					if (String.valueOf(car.getNum()).equals(s))
						newList.add(car);
				}
			}
			param.put("list", list);
		}
		UserBean user = (UserBean) request.getSession().getAttribute(uFlag);
		param.put("user", user);
		log.debug("assembleOrder response:"+param);
		return param;
		
	}
}
