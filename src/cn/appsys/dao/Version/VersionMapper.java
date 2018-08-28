package cn.appsys.dao.Version;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.Version;

@Repository
public interface VersionMapper {
	//功能五：新增App版本信息
	public int addAppVersion(Version version);

}
