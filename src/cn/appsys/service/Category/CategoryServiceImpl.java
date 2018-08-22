package cn.appsys.service.Category;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.Category.CategoryMapper;
@Service
public class CategoryServiceImpl implements  CategoryService {
	@Resource
	private CategoryMapper categoryMapper;
}
