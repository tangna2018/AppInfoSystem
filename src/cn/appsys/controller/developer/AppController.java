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

	// ����������ѯApp��Ϣ�б�
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

	// ����App������Ϣ
	@RequestMapping("/addAppInfo.html")
	public String addAppInofo(@ModelAttribute AppInfo appInfo) {
		return "addAppInfo";

	}

	// ��������App������Ϣ
	@RequestMapping("/addAppInfo.html")
	public String dodAdAppInofo(AppInfo appInfo) {
		if (appInfoService.addAppInfo(appInfo) < 1) {
			return "addAppInfo";
		} else {
			return "showAllAppInfo";// ����չʾҳ��
		}
	}

	// �޸�App������Ϣ
	@RequestMapping("/updateAppInfo.html")
	public String updateAppInofo(@RequestParam("id") Integer id, HttpSession session) {
		// ���Ƿ������޸�״̬ ���δͨ��/�����״̬�� �ſ����޸� �Ѿ����ͨ�������޸� ֻ������
		// ����id���AppInfo����
		AppInfo appInfo = appInfoService.getAppInfoById(id);
		if (appInfo.getStatus() == 1 || appInfo.getStatus() == 3) {// ��������
			return "updateAppInfo";
		} else {
			session.setAttribute(Constants.UPDATA_MESSAGE, "���ǿ����޸ĵ�״̬��");
			return "showAllAppInfo";
		}

	}

	// �޸�App������Ϣ
	@RequestMapping("/doUpdateAppInfo.html")
	public String doUpdateAppInofo(AppInfo appInfo) {

		if (appInfoService.addAppInfo(appInfo) < 1) {
			return "addAppInfo";
		} else {
			return "showAllAppInfo";// ����չʾҳ��
		}
	}

	// �����壺����App�汾��Ϣ
	@RequestMapping("/addAppVersion.html")
	public String addAppVersion(@ModelAttribute Version version) {

		return "addAppVersion";
	}

	// �����壺��������App�汾��Ϣ
	@RequestMapping("/doAddAppVersion.html")
	public String doAddAppVersion(Version version,HttpServletRequest request,
			@RequestParam(value="a_packagePath",required=false)MultipartFile attach) {
		String apkLocPath=null;//apk�ļ��ķ������洢·��
		String apkFileName=null;
		
		//�ж��Ƿ�Ϊ��
		if(!attach.isEmpty()){
			//1�������ϴ�·��
			String path=request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
			logger.info("=====path:=======>"+path);
			//2����ȡԭ�ļ���
			String oldFileName=attach.getOriginalFilename();
			logger.info("===oldFileName===>"+oldFileName);
			//3����ȡ��׺��
			String surffix=FilenameUtils.getExtension(oldFileName);
			logger.info("===surffix===>"+surffix);
			//4����ȡ�ļ���С ���жԱ�
			int filesize=500000;
			logger.info("===size===>"+attach.getSize());
			if(attach.getSize()>filesize){
				request.setAttribute("uploadFileError", "*�ϴ��ļ���С���ó���500kB");
				return "addAppVersion";
			}else if(surffix.equalsIgnoreCase("apk")){
				//5��������
				String fileName=System.currentTimeMillis()+
						RandomUtils.nextInt(1000000)+"version.apk";
				logger.info("===new fileName===>"+attach.getName());
				//6������file���� pathΪĿ��·�� fileNameΪ�ļ���  ��֤���ļ�
				File targetFile=new File(path, fileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				//�����û��ϴ��ļ���
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("uploadFileError", "*�ϴ�ʧ��");
					return "addAppVersion";
				}
				
				apkLocPath=path+oldFileName;
				apkFileName=oldFileName;
			
			}else{
				request.setAttribute("uploadFileError", "*�ϴ�ͼƬ��ʽ����ȷ");
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
