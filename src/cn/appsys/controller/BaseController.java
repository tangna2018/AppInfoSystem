package cn.appsys.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
//ʱ��ת��
public class BaseController {
	/**
	 * CustomDateEditor �Զ�������ڱ༭��
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
