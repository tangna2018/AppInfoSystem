package cn.appsys.dao.Version;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.Version;

@Repository
public interface VersionMapper {
	//�����壺����App�汾��Ϣ
	public int addAppVersion(Version version);

}
