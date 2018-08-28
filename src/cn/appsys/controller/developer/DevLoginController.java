package cn.appsys.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.Dev_user;
import cn.appsys.service.developer.Dev_userService;
import cn.appsys.tools.Constants;

@Controller
public class DevLoginController {
	private Logger logger = Logger.getLogger(DevLoginController.class);
	@Resource
	private Dev_userService devUserService;
	
	//登录。。
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController welcome AppInfoSystem develpor==================");
		return "devlogin";
	}
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doLogin(@RequestParam String devCode,@RequestParam String devPassword,HttpServletRequest request,HttpSession session){
		logger.debug("doLogin====================================");
		//调用service方法，进行用户匹配
		Dev_user user = null;
		try {
			user = devUserService.getLoginUser(devCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null != user&&user.getDevPassword().equals(devPassword)){//登录成功
			//放入session
			session.setAttribute(Constants.DEV_USER_SESSION, user);
			//页面跳转（main.jsp）
			return "redirect:/dev/flatform/main";
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "devlogin";
		}
	}
	
	//注销
		@RequestMapping("/outdevuser.html")
		public String outBackend_user(HttpSession session){
			//删除会话
			session.removeAttribute(Constants.DEV_USER_SESSION);
			
			return "devlogin";//注销后返回登录页面
		}
		
		
	
	
	
	
}

