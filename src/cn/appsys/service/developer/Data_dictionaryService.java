package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.Data_dictionary;

public interface Data_dictionaryService {
	// ����ƽ̨ aap��� �õ�����ƽ̨  ����ҳ��չʾ
	public List<Data_dictionary> getAPP_FLATFORM(String typeCode);


}
