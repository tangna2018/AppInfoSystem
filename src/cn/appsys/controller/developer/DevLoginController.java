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
	
	//��¼����
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController welcome AppInfoSystem develpor==================");
		return "devlogin";
	}
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doLogin(@RequestParam String devCode,@RequestParam String devPassword,HttpServletRequest request,HttpSession session){
		logger.debug("doLogin====================================");
		//����service�����������û�ƥ��
		Dev_user user = null;
		try {
			user = devUserService.getLoginUser(devCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null != user&&user.getDevPassword().equals(devPassword)){//��¼�ɹ�
			//����session
			session.setAttribute(Constants.DEV_USER_SESSION, user);
			//ҳ����ת��main.jsp��
			return "redirect:/dev/flatform/main";
		}else{
			//ҳ����ת��login.jsp��������ʾ��Ϣ--ת��
			request.setAttribute("error", "�û��������벻��ȷ");
			return "devlogin";
		}
	}
	
	//ע��
		@RequestMapping("/outdevuser.html")
		public String outBackend_user(HttpSession session){
			//ɾ���Ự
			session.removeAttribute(Constants.DEV_USER_SESSION);
			
			return "devlogin";//ע���󷵻ص�¼ҳ��
		}
		
		
	
	
	
	
}

