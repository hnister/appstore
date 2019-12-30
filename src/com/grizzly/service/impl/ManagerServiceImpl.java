package com.grizzly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.grizzly.dao.BackendUserMapper;
import com.grizzly.model.BackendUser;
import com.grizzly.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Resource
	private BackendUserMapper mapper;
	
	@Override
	public BackendUser login(String userCode, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		BackendUser user = null;
		user = mapper.getLoginUser(userCode);
		//匹配密码
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}

}
