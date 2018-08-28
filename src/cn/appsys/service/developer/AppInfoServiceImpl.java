package cn.appsys.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
@Service("devAppInfo")
public class AppInfoServiceImpl implements AppInfoService {
	@Resource
	private AppInfoMapper appInfoMapper;

	// ����������ѯ����б� ����ҳ
	public List<AppInfo> getCheckedAppInfo(String querySoftName, Integer flatformId, Integer categoryLevel1,
			Integer categoryLevel2, Integer categoryLevel3, Integer pageIndex, Integer pageSize) {

		return appInfoMapper.getCheckedAppInfo(querySoftName, flatformId, categoryLevel1, categoryLevel2,
				categoryLevel3, pageIndex, pageSize);
	}

	// ����������ѯ����б� ����ҳ ������
	public int gettotalCount(String querySoftName, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3) {
		return appInfoMapper.gettotalCount(querySoftName, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
	}

	
	// ����App������Ϣ
	public int addAppInfo(AppInfo appInfo) {
		return appInfoMapper.addAppInfo(appInfo);
	}
	
	//����id��ȡApp������Ϣ
	   public AppInfo getAppInfoById(Integer id) {
		return appInfoMapper.getAppInfoById(id);
	}

}
