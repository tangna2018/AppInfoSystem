package cn.appsys.service.Backend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.Category;
import cn.appsys.pojo.Data_dictionary;

public interface AppInfoService {

	// 所属平台 aap审核 得到所属平台  用于页面展示
	public List<Data_dictionary> getAPP_FLATFORM(String typeCode);

	// 查询出1级分类  用于页面展示
	public List<Category> getLevel1();

	// 根据1级分类联动获得2级分类 用于页面展示
	public List<Category> getLevel2(Integer level1id);

	// 根据2级分类联动获得3级分类 用于页面展示
	public List<Category> getLevel3(Integer level2id);

	// 根据条件查询审核列表 带分页 后台管理
	public List<AppInfo> getCheckedAppInfo(@Param("querySoftName") String querySoftName,
											@Param("flatformId") Integer flatformId, 
											@Param("categoryLevel1") Integer categoryLevel1,
											@Param("categoryLevel2") Integer categoryLevel2,
											@Param("categoryLevel3") Integer categoryLevel3,
											@Param("from") Integer pageIndex, 
											@Param("pageSize") Integer pageSize);

}
