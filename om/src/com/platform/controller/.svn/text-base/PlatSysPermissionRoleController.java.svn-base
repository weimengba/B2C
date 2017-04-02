package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.MM;
import com.util.MMUtil;

@Controller
@RequestMapping("/plat/sys")
public class PlatSysPermissionRoleController extends BasePlatController{

	/**
	 * 查询
	 * @return
	 */
	@RequestMapping("permissionroleList")
	public ModelAndView permissionRole(){
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platSysService.SelectPermissionRoleList();
		PageInfo page = new PageInfo(data);
		mav.addObject("data",page);
		
		mav.setViewName("/plat/sys/permissionroleList");
		return mav;
	}
	/**
	 * 添加或修改跳转
	 * @return
	 */
	@RequestMapping("/syspermissionrole")
	public ModelAndView sysPermissionRole() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.setViewName("/plat/sys/permissionrole");
		return mav;
	}
	
	/**
	 * 提交修改或添加管理员
	 * 
	 * @return
	 */
	@RequestMapping("/permissionroleSave")
	public ModelAndView permissionroleSave() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();

		if (mm.get("id") != null) {
			platSysService.insertpermissionrole();
		}

		mav.setViewName("redirect:/plat/sys/permissionroleList.do");
		return mav;
	}

}
