package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
import cn.appsys.dao.Version.VersionMapper;
import cn.appsys.pojo.Version;
@Service
public class VersionServiceImpl implements  VersionService {
	@Resource
	private VersionMapper versionMapper;
	//�����壺����App�汾��Ϣ
		public int addAppVersion(Version version) {
		return versionMapper.addAppVersion(version);
	}
}
