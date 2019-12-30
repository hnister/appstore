package com.grizzly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.grizzly.dao.AppInfoMapper;
import com.grizzly.dao.BackendUserMapper;
import com.grizzly.model.AppInfo;
import com.grizzly.model.BackendUser;
import com.grizzly.service.ManagerService;



@Service
public class ManagerServiceImpl implements ManagerService {

	@Resource
	private AppInfoMapper mapper;
	@Resource
	private BackendUserMapper umapper;
	
	@Override
	public AppInfo getAppInfo(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppInfo(id, null);
	}

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName,
									Integer queryCategoryLevel1,
									Integer queryCategoryLevel2, Integer queryCategoryLevel3,
									Integer queryFlatformId,Integer currentPageNo,
									Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppInfoList(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2, 
				                 queryCategoryLevel3, queryFlatformId, null, (currentPageNo-1)*pageSize, pageSize);
	}

	@Override
	public int getAppInfoCount(String querySoftwareName,
							Integer queryCategoryLevel1, 
							Integer queryCategoryLevel2,
							Integer queryCategoryLevel3, 
							Integer queryFlatformId)
							throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppInfoCount(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2, 
									queryCategoryLevel3, queryFlatformId, null);
	}

	@Override
	public boolean updateSatus(Integer status, Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mapper.updateSatus(status, id) > 0 ){
			flag = true;
		}
		return flag;
	}

	@Override
	public BackendUser login(String userCode, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		BackendUser user = null;
		user = umapper.getLoginUser(userCode);
		//匹配密码
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}
}
