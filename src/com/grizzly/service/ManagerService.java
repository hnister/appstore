package com.grizzly.service;

import com.grizzly.model.BackendUser;

public interface ManagerService {

	public BackendUser login(String userCode,String userPassword) throws Exception;

}
