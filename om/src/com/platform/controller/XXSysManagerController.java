package com.platform.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.platform.service.XXPlatSysManagerServiceI;
import com.util.MM;
import com.util.MMUtil;

@Controller
@RequestMapping("/xx")
public class XXSysManagerController extends BasePlatController {

	@Resource
	XXPlatSysManagerServiceI xxPlatSysManagerService;

	@RequestMapping("/sysManagerList")
	public ModelAndView sysManagerList() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = xxPlatSysManagerService
				.selectSysManager();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);

		mav.setViewName("/xx/sysManagerList");
		return mav;
	}

	@RequestMapping("/sysManager")
	public ModelAndView sysManager() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "sysManager");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.setViewName("/xx/sysManager");
		return mav;
	}

	@RequestMapping("/sysManagerSave")
	public ModelAndView sysManagerSave() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		
		if (mm.get("id") != null) {
			xxPlatSysManagerService.updateSysManager();
		}else{
			xxPlatSysManagerService.insertSysManager();
		}

		mav.setViewName("redirect:/xx/sysManagerList.do");
		return mav;
	}

	@RequestMapping("/sysManagerDelete")
	public ModelAndView sysManagerDelete() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "sysManager");
			Object data = commonService.updateCommonDeleteById();
		}
		mav.setViewName("redirect:/xx/sysManagerList.do");
		return mav;
	}

}