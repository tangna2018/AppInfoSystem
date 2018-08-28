package cn.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.appsys.pojo.Backend_user;
import cn.appsys.pojo.Dev_user;
import cn.appsys.tools.Constants;
public class BackendSysInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();

		Backend_user backend_user = (Backend_user) session.getAttribute(Constants.BACKEND_USER_SESSION);
		
		if (null!= backend_user) {
			return true;
		}else{
			response.sendRedirect(request.getContextPath() + "/401.jsp");
			return false;
		}


	}
}
