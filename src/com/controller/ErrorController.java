package com.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ErrorService;

@Controller
public class ErrorController {

	@Autowired
	private ErrorService errorService;
	private static Logger log = LoggerFactory.getLogger(ErrorController.class);
	
	@RequestMapping(value="/selectsp", method = RequestMethod.GET )
	@ResponseBody
	public Map<String, Object> selectSpByCode(@RequestParam(value="errorCode") String errorCode){
		Map<String, Object> param = new HashMap<String, Object>();
		log.debug("request input errorCode:" + errorCode);
		param.put("errorCode", Integer.valueOf(errorCode));
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		param.put("endTime", f.format(d));
		Calendar c = Calendar.getInstance();
		c.set(c.HOUR_OF_DAY, 0);
		c.set(c.MINUTE, 0);
		c.set(c.SECOND, 0);
		String startTime = f.format(c.getTime());
		param.put("startTime", startTime);
		System.out.println("param value:" + param.toString());
		Map<String, Object> params = errorService.selectSpByCode(param);
		log.debug("response:" + params.toString());
		return params;
	}
	
	@RequestMapping("/selectall")
	@ResponseBody
	public Map<String, Object> selectAllByCode(HttpServletRequest req){
		String errorCode = req.getParameter("errorCode");
		Map<String, Object> param = new HashMap<String, Object>();
		Calendar c = Calendar.getInstance();
		log.debug("request input errorCode:" + errorCode);
		param.put("errorCode", errorCode);
		param.put("endTime", c.getTime());
		c.set(c.HOUR_OF_DAY, 0);
		c.set(c.MINUTE, 0);
		c.set(c.SECOND, 0);
		param.put("startTime", c.getTime());
		List<Error> error = errorService.selectByCode(param);
		param = new HashMap<String, Object>();
		param.put("error", error);
		log.debug("response:" + param.toString());
		return param;
	}
}
