package com.grizzly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.grizzly.model.AppCategory;

public interface AppCategoryMapper {
	
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId")Integer parentId)throws Exception;
}
