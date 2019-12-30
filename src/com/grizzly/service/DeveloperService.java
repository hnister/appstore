package com.grizzly.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.grizzly.model.AppInfo;
import com.grizzly.utils.PageInfo;;

public interface DeveloperService {
    public String getAppInforms(Model model);

    PageInfo<AppInfo> allAppInformByPage(Map<String, Object> params);
}