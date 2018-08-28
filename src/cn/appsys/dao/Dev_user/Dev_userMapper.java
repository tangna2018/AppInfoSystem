package cn.appsys.dao.Dev_user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.appsys.pojo.Dev_user;

@Repository
public interface Dev_userMapper {
	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public Dev_user getLoginUser(@Param("devCode")String devCode);

}
