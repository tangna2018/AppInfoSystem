package cn.appsys.service.Backend;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
@Service("backendAppInfo")
public class AppInfoServiceImpl implements  AppInfoService {
	@Resource
	private AppInfoMapper appInfoMapper;
}
