package cn.appsys.dao.Backend_user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.appsys.pojo.Backend_user;
//��̨����ϵͳ
@Repository
public interface Backend_userMapper {
	//��̨ע����֤
	public Backend_user getBackendLoginMessage(@Param("userName")String userName,
			@Param("userPassword")String userPassword);
		
}
