package cn.appsys.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import cn.appsys.service.AppInfo.AppInfoService;

@Controller
public class AppInfoController extends BaseController{
		private Logger logger=Logger.getLogger(AppInfoController.class);
		@Resource
		private AppInfoService appInfoService;
}
