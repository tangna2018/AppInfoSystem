package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
import cn.appsys.dao.Version.VersionMapper;
@Service
public class VersionServiceImpl implements  VersionService {
	@Resource
	private VersionMapper versionMapper;
}
