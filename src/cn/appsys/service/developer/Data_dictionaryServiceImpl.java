package cn.appsys.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.Data_dictionary.Data_dictionaryMapper;
import cn.appsys.pojo.Data_dictionary;
@Service
public class Data_dictionaryServiceImpl implements  Data_dictionaryService {
	@Resource
	private Data_dictionaryMapper data_dictionaryMapper;
	// 所属平台 aap审核 得到所属平台  用于页面展示
	public List<Data_dictionary> getAPP_FLATFORM(String typeCode) {
		return data_dictionaryMapper.getAPP_FLATFORM(typeCode);
	}

}
