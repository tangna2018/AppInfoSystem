package cn.appsys.service.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.Category;
import cn.appsys.pojo.Data_dictionary;

public interface AppInfoService {
	//根据条件查询审核列表  带分页   
	public List<AppInfo> getCheckedAppInfo(String querySoftName,
			    Integer flatformId,
			    Integer categoryLevel1,
			   Integer categoryLevel2,
			    Integer categoryLevel3,
			    Integer pageIndex,
			    Integer pageSize);
	
	
	//根据条件查询审核列表  带分页    总条数
			public int gettotalCount(String querySoftName,
				    Integer flatformId,
				    Integer categoryLevel1,
				   Integer categoryLevel2,
				    Integer categoryLevel3);
			
		
			//根据id获取App基础信息
			   public AppInfo getAppInfoById(Integer id);	
			
			//新增App基础信息
			public int addAppInfo(AppInfo appInfo);

}
