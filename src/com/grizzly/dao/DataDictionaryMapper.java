package com.grizzly.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.grizzly.model.DataDictionary;

public interface DataDictionaryMapper {
	
	public List<DataDictionary> getDataDictionaryList(@Param("typeCode")String typeCode)throws Exception;
}
