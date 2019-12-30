package com.grizzly.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.grizzly.dao.DeveloperMapper;
import com.grizzly.model.AppInfo;
import com.grizzly.service.DeveloperService;
import com.grizzly.utils.PageInfo;;

@Service("Developer")
@Transactional
public class DeveloperServicImpl implements DeveloperService {
    @Resource
    public DeveloperMapper developerMapper;

    @Override
    public String getAppInforms(Model model) {
        // TODO Auto-generated method stub
        List<AppInfo> appinforms = developerMapper.allAppInform();
        System.out.println("共有" + appinforms.size() + "条产品信息");
        model.addAttribute("appinforms", appinforms);
        return "main";
    }

    @Override
    public PageInfo<AppInfo> allAppInformByPage(Map<String, Object> params) {
        PageInfo<AppInfo> pageInfo = new PageInfo<AppInfo>();
        if (params.containsKey("pageNow")) {
            Integer pageNow = (Integer) params.get("pageNow");
            pageInfo.setPageNow(pageNow);
        }
        pageInfo.setCount(developerMapper.countAppInforms(params));

        params.put("start", (pageInfo.getPageNow() - 1) * pageInfo.getPageSize());
        params.put("size", pageInfo.getPageSize());

        System.out.println(params.toString());

        pageInfo.setList(developerMapper.selectByPage(params));
        return pageInfo;
    }
}
