package cn.appsys.dao.AppInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.appsys.pojo.AppInfo;

@Repository
public interface AppInfoMapper {
		//����������ѯ����б�  ����ҳ   
	public List<AppInfo> getCheckedAppInfo(@Param("querySoftName")String querySoftName,
			    @Param("flatformId")Integer flatformId,
			    @Param("categoryLevel1")Integer categoryLevel1,
			    @Param("categoryLevel2")Integer categoryLevel2,
			    @Param("categoryLevel3")Integer categoryLevel3,
			    @Param("from")Integer pageIndex,
			    @Param("pageSize")Integer pageSize);
	
	//����������ѯ����б�  ����ҳ    ������
		public int gettotalCount(@Param("querySoftName")String querySoftName,
				    @Param("flatformId")Integer flatformId,
				    @Param("categoryLevel1")Integer categoryLevel1,
				    @Param("categoryLevel2")Integer categoryLevel2,
				    @Param("categoryLevel3")Integer categoryLevel3
				   );
		//����App������Ϣ
		public int addAppInfo(AppInfo appInfo);
		//����id��ȡApp������Ϣ
	   public AppInfo getAppInfoById( @Param("id")Integer id);

}
