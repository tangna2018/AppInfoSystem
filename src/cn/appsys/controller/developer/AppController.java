package cn.appsys.controller.developer;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.Version;
import cn.appsys.service.developer.AppInfoService;
import cn.appsys.service.developer.Data_dictionaryService;
import cn.appsys.service.developer.VersionService;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;

@Controller
public class AppController {
	private Logger logger = Logger.getLogger(AppController.class);

	@Resource(name = "devAppInfo")
	private AppInfoService appInfoService;
	@Resource
	private Data_dictionaryService Data_dictionaryService;
	@Resource
	private VersionService versionService;

	// 根据条件查询App信息列表
	@RequestMapping(value = "/getAllAppInfo.html")
	public String getAllAppInfo(@RequestParam("querySoftName") String querySoftName,
			@Param("flatformId") Integer flatformId, @RequestParam("categoryLevel1") Integer categoryLevel1,
			@Param("categoryLevel2") Integer categoryLevel2, @RequestParam("categoryLevel3") Integer categoryLevel3,
			@Param("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize, Model model) {
		Integer pageSize1 = 5;
		Integer currentPageNo = pageIndex;
		if (pageSize != null) {
			pageSize1 = pageSize;
		}
		PageSupport page = new PageSupport();
		page.setCurrentPageNo(currentPageNo);

		int totalCount = appInfoService.gettotalCount(querySoftName, flatformId, categoryLevel1, categoryLevel2,
				categoryLevel3);
		page.setPageSize(pageSize1);
		page.setTotalCount(totalCount);
		Integer totalPageCount = page.getTotalPageCount();

		List<AppInfo> list = appInfoService.getCheckedAppInfo(querySoftName, flatformId, categoryLevel1, categoryLevel2,
				categoryLevel3, pageIndex, pageSize1);
		model.addAttribute("AppInfoList", list);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPageCount", totalPageCount);

		return "showAllAppInfo";

	}

	// 新增App基础信息
	@RequestMapping("/addAppInfo.html")
	public String addAppInofo(@ModelAttribute AppInfo appInfo) {
		return "addAppInfo";

	}

	// 处理新增App基础信息
	@RequestMapping("/addAppInfo.html")
	public String dodAdAppInofo(AppInfo appInfo) {
		if (appInfoService.addAppInfo(appInfo) < 1) {
			return "addAppInfo";
		} else {
			return "showAllAppInfo";// 返回展示页面
		}
	}

	// 修改App基础信息
	@RequestMapping("/updateAppInfo.html")
	public String updateAppInofo(@RequestParam("id") Integer id, HttpSession session) {
		// 看是否满足修改状态 审核未通过/待审核状态下 才可以修改 已经审核通过后不能修改 只能增加
		// 根据id获得AppInfo对象
		AppInfo appInfo = appInfoService.getAppInfoById(id);
		if (appInfo.getStatus() == 1 || appInfo.getStatus() == 3) {// 满足条件
			return "updateAppInfo";
		} else {
			session.setAttribute(Constants.UPDATA_MESSAGE, "不是可以修改的状态！");
			return "showAllAppInfo";
		}

	}

	// 修改App基础信息
	@RequestMapping("/doUpdateAppInfo.html")
	public String doUpdateAppInofo(AppInfo appInfo) {

		if (appInfoService.addAppInfo(appInfo) < 1) {
			return "addAppInfo";
		} else {
			return "showAllAppInfo";// 返回展示页面
		}
	}

	// 功能五：新增App版本信息
	@RequestMapping("/addAppVersion.html")
	public String addAppVersion(@ModelAttribute Version version) {

		return "addAppVersion";
	}

	// 功能五：处理新增App版本信息
	@RequestMapping("/doAddAppVersion.html")
	public String doAddAppVersion(Version version,HttpServletRequest request,
			@RequestParam(value="a_packagePath",required=false)MultipartFile attach) {
		String apkLocPath=null;//apk文件的服务器存储路径
		String apkFileName=null;
		
		//判断是否为空
		if(!attach.isEmpty()){
			//1、定义上传路径
			String path=request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
			logger.info("=====path:=======>"+path);
			//2、获取原文件名
			String oldFileName=attach.getOriginalFilename();
			logger.info("===oldFileName===>"+oldFileName);
			//3、获取后缀名
			String surffix=FilenameUtils.getExtension(oldFileName);
			logger.info("===surffix===>"+surffix);
			//4、获取文件大小 进行对比
			int filesize=500000;
			logger.info("===size===>"+attach.getSize());
			if(attach.getSize()>filesize){
				request.setAttribute("uploadFileError", "*上传文件大小不得超过500kB");
				return "addAppVersion";
			}else if(surffix.equalsIgnoreCase("apk")){
				//5、重命名
				String fileName=System.currentTimeMillis()+
						RandomUtils.nextInt(1000000)+"version.apk";
				logger.info("===new fileName===>"+attach.getName());
				//6、创建file对象 path为目标路径 fileName为文件名  保证有文件
				File targetFile=new File(path, fileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				//接收用户上传文件流
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("uploadFileError", "*上传失败");
					return "addAppVersion";
				}
				
				apkLocPath=path+oldFileName;
				apkFileName=oldFileName;
			
			}else{
				request.setAttribute("uploadFileError", "*上传图片格式不正确");
				return "addAppVersion";
			}
		}
			version.setApkFileName(apkFileName);
			version.setApkLocPath(apkLocPath);
		
		if(versionService.addAppVersion(version)>0){
			return "showAllAppInfo";
		}else{
			
		}
			return "addAppVersion";
		
	}
	
		
	
	
	
	
}
