package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
@Service
public class AppInfoServiceImpl implements  AppInfoService {
	@Resource
	private AppInfoMapper appInfoMapper;
}
