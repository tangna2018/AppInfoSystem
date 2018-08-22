package cn.appsys.controller.developer;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import cn.appsys.service.developer.AppInfoService;

@Controller
public class AppController {
	private Logger logger = Logger.getLogger(AppController.class);
	@Resource(name="devAppInfo")
	private AppInfoService appInfoService;
	
}
