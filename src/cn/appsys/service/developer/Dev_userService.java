package cn.appsys.service.developer;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.Dev_user;

public interface Dev_userService {
	public Dev_user getLoginUser(@Param("devCode")String devCode);

}
