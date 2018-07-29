package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.mapper.ErrorMapper;

@Repository
public class ErrorDao {

	@Autowired
	private ErrorMapper errorMapper;
	
	public List<Error> selectSpByCode(Map<String,Object> map) {
		return errorMapper.selectSpByCode(map);
	}
	
	public List<Error> selectIpByCode(Map<String,Object> map) {
		return errorMapper.selectIpByCode(map);
	}
	
	public List<Error> selectByCode(Map<String,Object> map) {
		return errorMapper.selectByCode(map);
	}
}
