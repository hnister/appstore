package com.grizzly.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grizzly.model.AppInform;
import com.grizzly.service.DeveloperService;
import com.grizzly.utils.PageInfo;

@Controller
public class DeveloperController {
	@Autowired
	private DeveloperService developerService;
	
	@RequestMapping("/getappinforms")
	public String getAppInforms(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		return  developerService.getAppInforms(model);
	}
	
	@RequestMapping("/selectAppInformByPage")
	public String selectAppInformByPage(Integer pageNow ,String softwareName, Integer id , Model model) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(pageNow != null) {
			params.put("pageNow", pageNow);
		}
		if(softwareName != null && softwareName.length()> 0) {
			params.put("softwareName", "%"+softwareName+"%");
		}
		if(id != null && id != -1) {
			params.put("id", id);
		}
		System.out.println(params.toString());
		PageInfo<AppInform> pageInfo = developerService.allAppInformByPage(params);
		model.addAttribute("pageInfo", pageInfo);
		return "appinformlist";
	}
	
	@RequestMapping("/dev/login")
	public String devLogin(Model model) {
		return "devlogin";
	}
}
