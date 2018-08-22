package cn.appsys.service.Backend_user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.appsys.dao.Backend_user.Backend_userMapper;

@Service
public class Backend_userServiceImpl implements  Backend_userService {
	@Resource
	private Backend_userMapper Backend_userMapper;
}
