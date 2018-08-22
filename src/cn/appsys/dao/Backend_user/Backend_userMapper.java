package cn.appsys.dao.Backend_user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.appsys.pojo.Backend_user;
//后台管理系统
@Repository
public interface Backend_userMapper {
	//后台注册验证
	public Backend_user getBackendLoginMessage(@Param("userName")String userName,
			@Param("userPassword")String userPassword);
		
}
