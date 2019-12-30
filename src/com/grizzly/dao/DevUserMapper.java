package com.grizzly.dao;

import org.apache.ibatis.annotations.Param;

import com.grizzly.model.DevUser;

public interface DevUserMapper {
	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getLoginUser(@Param("devCode")String devCode)throws Exception;
}
