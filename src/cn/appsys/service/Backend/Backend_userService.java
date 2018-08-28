package cn.appsys.service.Backend;


import cn.appsys.pojo.Backend_user;

public interface Backend_userService {
	//后台注册验证
	public Backend_user getBackendLoginMessage(String userCode,String userPassword);
	

}
