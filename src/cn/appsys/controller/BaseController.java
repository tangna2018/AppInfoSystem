package cn.appsys.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
//时间转换
public class BaseController {
	/**
	 * CustomDateEditor 自定义的日期编辑器
	 * 
	 * @param dataBinder
	 */
	 
	@InitBinder  
	public void initBinder(WebDataBinder dataBinder){
		System.out.println("initBinder=======");
		dataBinder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
		
		
	}


}
