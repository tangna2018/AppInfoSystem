package cn.appsys.controller.backend;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.controller.BaseController;
import cn.appsys.service.Backend.AppInfoService;

@Controller
public class AppInfoController extends BaseController{
		private Logger logger=Logger.getLogger(AppInfoController.class);
		@Resource(name="backendAppInfo")
		private AppInfoService appInfoService;
		
		
		
		
		//根据条件查询待审核APP信息列表
		
		@RequestMapping("/checkedlist.html")
		public String getCheckedList(){
			
			
			
			return null;
			
		}
		
		
		
		
		
		
		
		
		
		
		//审核
		
		
		
		
		
		
		
}
