package cn.appsys.dao.Data_dictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.appsys.pojo.Data_dictionary;

@Repository
public interface Data_dictionaryMapper {
	//����ƽ̨ aap���
	public List<Data_dictionary> getAPP_FLATFORM(@Param("typeCode")String typeCode);

}
