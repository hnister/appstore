package com.grizzly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.grizzly.model.BackendUser;
import com.grizzly.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("manager/login")
	public String toManagerLoginPage() {
		return "backendlogin";
	}
	
	@RequestMapping(value="manager/dologin",method=RequestMethod.POST)
	public String doLogin(@RequestParam String userCode,@RequestParam String userPassword,HttpServletRequest request,HttpSession session){
		//调用service方法，进行用户匹配
		BackendUser user = null;
		try {
			user = managerService.login(userCode,userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null != user){//登录成功
			//放入session
//			session.setAttribute(Constants.USER_SESSION, user);
			//页面跳转（main.jsp）
			return "redirect:/manager/backend/main";
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "backendlogin";
		}
	}
}
