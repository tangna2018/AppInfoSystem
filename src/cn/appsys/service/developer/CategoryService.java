package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.Category;

public interface CategoryService {
	   // ��ѯ��1������ ����ҳ��չʾ
		public List<Category> getLevel1();

		// ����1�������������2������ ����ҳ��չʾ
		public List<Category> getLevel2(Integer level1id);

		// ����2�������������3������ ����ҳ��չʾ
		public List<Category> getLevel3(Integer level2id);


}
