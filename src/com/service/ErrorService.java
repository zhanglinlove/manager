package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ErrorDao;

@Service
public class ErrorService {

	@Autowired
	private ErrorDao errorDao;
	
	public Map<String, Object> selectSpByCode(Map<String,Object> map) {
		List<Error> list = errorDao.selectSpByCode(map);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sp", list);
		List<Error> ipList = errorDao.selectIpByCode(map);
		param.put("ip", ipList);
		return param;
	}
	
	
	public List<Error> selectByCode(Map<String,Object> map) {
		return errorDao.selectByCode(map);
	}
}
