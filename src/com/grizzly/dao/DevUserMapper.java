package com.grizzly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grizzly.model.DevUser;

public interface DevUserMapper {
	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public List <DevUser> getDevUsers(@Param("devName")String devName,@Param("from")int from,@Param("pageSize")int pageSize);
	public DevUser getLoginUser(@Param("devCode")String devCode)throws Exception;
	public int getDevInfoCount(@Param("devName")String devNmae);
	public int addDevInfo(DevUser devUser);
	public int findDevByCode(String devCode);
	public DevUser getDevById(int devId);
	public int updateDevInfo(DevUser devUser);
	public int deleteDevById(int id);
}
