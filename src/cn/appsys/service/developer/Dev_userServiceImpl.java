package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
import cn.appsys.dao.Dev_user.Dev_userMapper;
import cn.appsys.pojo.Dev_user;
@Service
public class Dev_userServiceImpl implements  Dev_userService {
	@Resource
	private Dev_userMapper dev_userMapper;

	@Override
	public Dev_user getLoginUser(String devCode) {
		return dev_userMapper.getLoginUser(devCode);
	}
}
