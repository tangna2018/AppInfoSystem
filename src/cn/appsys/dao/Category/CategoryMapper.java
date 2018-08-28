package cn.appsys.dao.Category;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.appsys.pojo.Category;

@Repository
public interface CategoryMapper {
	//��ѯ��1������
	public List<Category>  getLevel1();
	//����1�������������2������
	public List<Category> getLevel2(@Param("level1id")Integer level1id);
	//����2�������������3������
	public List<Category> getLevel3(@Param("level2id")Integer level2id);
}
