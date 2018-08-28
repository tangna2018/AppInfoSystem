package cn.appsys.service.Backend;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.appsys.dao.Backend_user.Backend_userMapper;
import cn.appsys.pojo.Backend_user;

@Service
public class Backend_userServiceImpl implements  Backend_userService {
	@Resource
	private Backend_userMapper Backend_userMapper;
	//后台注册验证
	public Backend_user getBackendLoginMessage(String userCode,String userPassword) {
		return Backend_userMapper.getBackendLoginMessage(userCode, userPassword);
	}
}
