package cn.appsys.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.controller.BaseController;
import cn.appsys.pojo.Backend_user;
import cn.appsys.service.Backend.Backend_userService;
import cn.appsys.tools.Constants;



@Controller
public class Backend_userLoginController  extends BaseController {
	@Resource
	private Backend_userService  backend_userService;
	private Logger logger=Logger.getLogger(Backend_userLoginController.class);
	
	@RequestMapping("/backend_userLogin.html")
	public String login(){
		return "backend_userLogin";
	}
	
	
	@RequestMapping("/dobackend_userLogin.html")
	public String dologin(@RequestParam(value="userName")String userName,
			@RequestParam(value="userPassword")String userPassword,Model model,HttpSession session){
		Backend_user buser=	backend_userService.getBackendLoginMessage(userName, userPassword);
		if(null==buser){
			model.addAttribute("backend_userMessage", "用户名和密码不匹配");
		}else{
			session.setAttribute(Constants.BACKEND_USER_SESSION,buser);
			return "redirect:/sys/backend_userMain.html";
		}
		return "backend_userLogin";
		
	}
	
	
	@RequestMapping("/sys/backend_userMain.html")
	public String backend_userMain(){
		
		return "backend_userMain";
	}
	
	
	
}
