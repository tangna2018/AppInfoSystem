package cn.appsys.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfo.AppInfoMapper;
import cn.appsys.dao.Category.CategoryMapper;
import cn.appsys.dao.Version.VersionMapper;
import cn.appsys.pojo.Category;
import cn.appsys.pojo.Version;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryMapper categoryMapper;

	// ��ѯ��1������ ����ҳ��չʾ
	public List<Category> getLevel1() {
		return categoryMapper.getLevel1();
	}

	// ����1�������������2������ ����ҳ��չʾ
	public List<Category> getLevel2(Integer level1id) {
		return categoryMapper.getLevel2(level1id);
	}

	// ����2�������������3������ ����ҳ��չʾ
	public List<Category> getLevel3(Integer level2id) {
		return categoryMapper.getLevel3(level2id);
	}

	
}
