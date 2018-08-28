package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.Data_dictionary;

public interface Data_dictionaryService {
	// 所属平台 aap审核 得到所属平台  用于页面展示
	public List<Data_dictionary> getAPP_FLATFORM(String typeCode);


}
