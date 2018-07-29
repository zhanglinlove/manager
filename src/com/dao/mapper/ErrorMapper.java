package com.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface ErrorMapper {

	public List<Error> selectSpByCode(Map<String,Object> map);
	public List<Error> selectIpByCode(Map<String,Object> map);
	public List<Error> selectByCode(Map<String,Object> map);
}
