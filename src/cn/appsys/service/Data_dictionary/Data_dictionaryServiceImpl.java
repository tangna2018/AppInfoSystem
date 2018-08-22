package cn.appsys.service.Data_dictionary;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.Data_dictionary.Data_dictionaryMapper;
@Service
public class Data_dictionaryServiceImpl implements  Data_dictionaryService {
	@Resource
	private Data_dictionaryMapper data_dictionaryMapper;
}
