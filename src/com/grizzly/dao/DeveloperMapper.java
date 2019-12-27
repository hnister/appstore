package com.grizzly.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.grizzly.model.AppInform;

@Repository("developerMapper")
@Mapper
public interface DeveloperMapper {
	public List<AppInform> allAppInform();

	int countAppInforms(@Param("params") Map<String,Object> params);
	
	List<AppInform> selectByPage(@Param("params") Map<String, Object> params);
}
