package com.grizzly.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.grizzly.model.AppInform;
import com.grizzly.utils.PageInfo;;
public interface DeveloperService {
	public String getAppInforms(Model model);
	
	PageInfo <AppInform> allAppInformByPage(Map<String,Object> params);
}