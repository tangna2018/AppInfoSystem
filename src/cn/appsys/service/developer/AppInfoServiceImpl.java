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

	// 根据条件查询审核列表 带分页
	public List<AppInfo> getCheckedAppInfo(String querySoftName, Integer flatformId, Integer categoryLevel1,
			Integer categoryLevel2, Integer categoryLevel3, Integer pageIndex, Integer pageSize) {

		return appInfoMapper.getCheckedAppInfo(querySoftName, flatformId, categoryLevel1, categoryLevel2,
				categoryLevel3, pageIndex, pageSize);
	}

	// 根据条件查询审核列表 带分页 总条数
	public int gettotalCount(String querySoftName, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3) {
		return appInfoMapper.gettotalCount(querySoftName, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
	}

	
	// 新增App基础信息
	public int addAppInfo(AppInfo appInfo) {
		return appInfoMapper.addAppInfo(appInfo);
	}
	
	//根据id获取App基础信息
	   public AppInfo getAppInfoById(Integer id) {
		return appInfoMapper.getAppInfoById(id);
	}

}
