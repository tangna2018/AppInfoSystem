package cn.appsys.service.Backend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.Category;
import cn.appsys.pojo.Data_dictionary;

public interface AppInfoService {

	// ����ƽ̨ aap��� �õ�����ƽ̨  ����ҳ��չʾ
	public List<Data_dictionary> getAPP_FLATFORM(String typeCode);

	// ��ѯ��1������  ����ҳ��չʾ
	public List<Category> getLevel1();

	// ����1�������������2������ ����ҳ��չʾ
	public List<Category> getLevel2(Integer level1id);

	// ����2�������������3������ ����ҳ��չʾ
	public List<Category> getLevel3(Integer level2id);

	// ����������ѯ����б� ����ҳ ��̨����
	public List<AppInfo> getCheckedAppInfo(@Param("querySoftName") String querySoftName,
											@Param("flatformId") Integer flatformId, 
											@Param("categoryLevel1") Integer categoryLevel1,
											@Param("categoryLevel2") Integer categoryLevel2,
											@Param("categoryLevel3") Integer categoryLevel3,
											@Param("from") Integer pageIndex, 
											@Param("pageSize") Integer pageSize);

}
