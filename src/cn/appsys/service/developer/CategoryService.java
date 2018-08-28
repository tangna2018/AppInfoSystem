package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.Category;

public interface CategoryService {
	   // 查询出1级分类 用于页面展示
		public List<Category> getLevel1();

		// 根据1级分类联动获得2级分类 用于页面展示
		public List<Category> getLevel2(Integer level1id);

		// 根据2级分类联动获得3级分类 用于页面展示
		public List<Category> getLevel3(Integer level2id);


}
