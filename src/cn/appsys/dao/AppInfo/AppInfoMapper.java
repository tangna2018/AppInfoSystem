package cn.appsys.dao.AppInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.appsys.pojo.AppInfo;

@Repository
public interface AppInfoMapper {
		//根据条件查询审核列表  带分页   
	public List<AppInfo> getCheckedAppInfo(@Param("querySoftName")String querySoftName,
			    @Param("flatformId")Integer flatformId,
			    @Param("categoryLevel1")Integer categoryLevel1,
			    @Param("categoryLevel2")Integer categoryLevel2,
			    @Param("categoryLevel3")Integer categoryLevel3,
			    @Param("from")Integer pageIndex,
			    @Param("pageSize")Integer pageSize);
	
	//根据条件查询审核列表  带分页    总条数
		public int gettotalCount(@Param("querySoftName")String querySoftName,
				    @Param("flatformId")Integer flatformId,
				    @Param("categoryLevel1")Integer categoryLevel1,
				    @Param("categoryLevel2")Integer categoryLevel2,
				    @Param("categoryLevel3")Integer categoryLevel3
				   );
		//新增App基础信息
		public int addAppInfo(AppInfo appInfo);
		//根据id获取App基础信息
	   public AppInfo getAppInfoById( @Param("id")Integer id);

}
