package cn.appsys.service.Backend;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
import cn.appsys.dao.Category.CategoryMapper;
import cn.appsys.dao.Data_dictionary.Data_dictionaryMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.Category;
import cn.appsys.pojo.Data_dictionary;

@Service("backendAppInfo")
public class AppInfoServiceImpl implements AppInfoService {
	@Resource
	private CategoryMapper categoryMapper;
	@Resource
	private AppInfoMapper appInfoMapper;
	@Resource
	private Data_dictionaryMapper data_dictionaryMapper;

	// ����ƽ̨ aap��� �õ�����ƽ̨
	public List<Data_dictionary> getAPP_FLATFORM(String typeCode) {
		return data_dictionaryMapper.getAPP_FLATFORM("APP_FLATFORM");
	}

	// ��ѯ��1������
	public List<Category> getLevel1() {
		return categoryMapper.getLevel1();
	}

	// ����1�������������2������
	public List<Category> getLevel2(Integer level1id) {
		return categoryMapper.getLevel2(level1id);
	}

	// ����2�������������3������
	public List<Category> getLevel3(Integer level2id) {
		return categoryMapper.getLevel3(level2id);
	}

	
	//����������ѯ����б�  ����ҳ    ��̨����
	@Override
	public List<AppInfo> getCheckedAppInfo(String querySoftName, Integer flatformId, Integer categoryLevel1,
			Integer categoryLevel2, Integer categoryLevel3, Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return appInfoMapper.getCheckedAppInfo(querySoftName, 
				flatformId, categoryLevel1, categoryLevel2,
				categoryLevel3, pageIndex, pageSize);
	}
	
	
	
	
	
}
