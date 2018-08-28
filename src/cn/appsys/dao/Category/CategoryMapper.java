package cn.appsys.dao.Category;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.appsys.pojo.Category;

@Repository
public interface CategoryMapper {
	//查询出1级分类
	public List<Category>  getLevel1();
	//根据1级分类联动获得2级分类
	public List<Category> getLevel2(@Param("level1id")Integer level1id);
	//根据2级分类联动获得3级分类
	public List<Category> getLevel3(@Param("level2id")Integer level2id);
}
