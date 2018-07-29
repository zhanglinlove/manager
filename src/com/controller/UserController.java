package com.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.UserBean;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/envTest")
	@ResponseBody
	public String envTest() {
		return userService.test();
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request, HttpServletResponse response){
		UserBean userBean = new UserBean();
		userBean.setPassword(request.getParameter("password"));
		userBean.setUsername(request.getParameter("username"));
		System.out.println("username="+request.getParameter("username")
				+";password="+request.getParameter("password"));
		int i = userService.insertUser(userBean);
		if (i > 0){
			String id = Integer.toString(i);
			request.getSession().setAttribute(id, userBean);
			Cookie cook = new Cookie("username", id);
			response.addCookie(cook);
		}
		return "/page/default.jsp";
	}


	@RequestMapping("/adminlogin")
	public ModelAndView adminLogin(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletRequest request,HttpServletResponse response){
		UserBean userBean = new UserBean();
		userBean.setPassword(password);
		userBean.setUsername(username);
		UserBean user = userService.adminLogin(userBean);
		ModelAndView view = new ModelAndView();
		view.addObject("username", user.getUsername());
		if (user != null && user.getUsername() != null){
			log.debug("登陆验证：userbean="+userBean.toString());
			/*String s = Long.toString(new Date().getTime());
			s = s.substring(s.length()-7) + (int)(Math.random()*100);*/
			String id = String.valueOf(user.getId());
			request.getSession().setAttribute(id, user);
			Cookie cook = new Cookie("username", id);
			cook.setMaxAge(1800);
			response.addCookie(cook);
			view.setViewName("/page/admin/manager.jsp");
		} else {
			view.setViewName("/page/adminLogin.jsp");
		}
		return view; 
		
	}

	@RequestMapping("/userLogin")
	public ModelAndView userLogin(@ModelAttribute("user") UserBean user,
			HttpServletRequest request, HttpServletResponse response){
		UserBean u = userService.adminLogin(user);
		ModelAndView view = new ModelAndView();
		
		if (u != null){
			view.addObject("username", u.getUsername());
			log.debug("登陆验证：u="+u.toString());
			String s = Long.toString(new Date().getTime());
			s = s.substring(s.length()-7) + (int)(Math.random()*100);
			request.getSession().setAttribute(s, u);
			Cookie cook = new Cookie("username", s);
			cook.setMaxAge(1800);
			response.addCookie(cook);
			view.setViewName("/page/default.jsp");
			/*request.setAttribute("username", u.getUsername());*/
		} else {
			view.setViewName("/page/userLogin.jsp");
		}
		return view;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		String flag = request.getParameter("flag");
		Cookie[] cooks = request.getCookies();
		String str = null;
		for(Cookie c : cooks){
			if("username".equals(c.getName())){
				str = c.getValue();
			}
		}
		if (str != null){
			request.getSession().removeAttribute(str);
		}
		if (flag == null || Integer.valueOf(flag) != 1)
			return "/page/userLogin.jsp";
		return "/page/adminLogin.jsp";
	}
}
