package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pojo.UserBean;

public class UserFilter implements Filter{

	private static Logger log = LoggerFactory.getLogger(UserFilter.class);
	
	public void destroy() {
		log.debug("UserFilter destroy...");
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		Cookie[] cook = req.getCookies();
		String str = "";
		for (Cookie c : cook){
			if ("username".equals(c.getName())){
				str = c.getValue();
				break;
			}
		}
		if (str != "" && str != null){
			UserBean admin = (UserBean) req.getSession().getAttribute(str);
			if (admin != null){
				arg2.doFilter(req, res);
			}
		} 
		req.getRequestDispatcher("/page/adminLogin.jsp").forward(req, res);
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
