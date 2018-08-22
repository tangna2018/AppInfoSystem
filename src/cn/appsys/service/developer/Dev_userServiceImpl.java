package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
import cn.appsys.dao.Dev_user.Dev_userMapper;
@Service
public class Dev_userServiceImpl implements  Dev_userService {
	@Resource
	private Dev_userMapper dev_userMapper;
}
