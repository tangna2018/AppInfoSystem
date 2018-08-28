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

	// 查询出1级分类 用于页面展示
	public List<Category> getLevel1() {
		return categoryMapper.getLevel1();
	}

	// 根据1级分类联动获得2级分类 用于页面展示
	public List<Category> getLevel2(Integer level1id) {
		return categoryMapper.getLevel2(level1id);
	}

	// 根据2级分类联动获得3级分类 用于页面展示
	public List<Category> getLevel3(Integer level2id) {
		return categoryMapper.getLevel3(level2id);
	}

	
}
