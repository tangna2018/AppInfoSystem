package cn.appsys.service.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.Category;
import cn.appsys.pojo.Data_dictionary;

public interface AppInfoService {
	//����������ѯ����б�  ����ҳ   
	public List<AppInfo> getCheckedAppInfo(String querySoftName,
			    Integer flatformId,
			    Integer categoryLevel1,
			   Integer categoryLevel2,
			    Integer categoryLevel3,
			    Integer pageIndex,
			    Integer pageSize);
	
	
	//����������ѯ����б�  ����ҳ    ������
			public int gettotalCount(String querySoftName,
				    Integer flatformId,
				    Integer categoryLevel1,
				   Integer categoryLevel2,
				    Integer categoryLevel3);
			
		
			//����id��ȡApp������Ϣ
			   public AppInfo getAppInfoById(Integer id);	
			
			//����App������Ϣ
			public int addAppInfo(AppInfo appInfo);

}
