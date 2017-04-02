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

/**
 * 角色
 * @author cqn
 *
 */
@Controller
@RequestMapping("/plat/sys")
public class PlatSysRoleController extends BasePlatController {
	
	/**
	 * 查询所有	
	 * @return
	 */
	@RequestMapping("/sysRoleList")
	public ModelAndView sysRoleList() {
		
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();         
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> selectSysManager = platSysService.selectSysRoleList();
		PageInfo pageInfo = new PageInfo(selectSysManager);
		mav.addObject("data",pageInfo);
		mav.setViewName("/plat/sys/sysRoleList");
		return mav;
	}
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("/sysRole")
	public ModelAndView sysRoleChange(){
		MM mm = MMUtil.getMM();
		ModelAndView modelAndView = new ModelAndView();
		if(mm.get("id") !=null){
			mm.put("c_tb", "sysRole");
			Object commonGetDataById = commonService.commonGetDataById();
			modelAndView.addObject("object",commonGetDataById );
		}
		modelAndView.setViewName("/plat/sys/sysRole");
		return modelAndView;
		
	}
	/**
	 * 角色添加修改
	 * @return
	 */
	@RequestMapping("/sysRoleSave")
	public ModelAndView sysRoleSave(){
		MM mm = MMUtil.getMM();
		ModelAndView modelAndView = new ModelAndView();
		if(mm.get("id") !=null){
			platSysService.updateSysRole();
		}else{
			platSysService.insertSysRole();
		}
		modelAndView.setViewName("redirect:/plat/sys/sysRoleList.do");
		return modelAndView;
	}
	/**
	 * 角色删除
	 * @return
	 */
	@RequestMapping("/sysRoleDelete")
	public ModelAndView sysRoleDelete(){
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if(mm.get("id") !=null){
			mm.put("c_tb", "sysManager");
			Object commonGetDataById = commonService.commonGetDataById();
		}
		mav.setViewName("redirect:/plat/sys/sysRoleList.do");
		return mav;
		
	}
	/**
	 * 添加权限
	 */
	@RequestMapping("/sysRolePermisssion")
	public ModelAndView sysRolePermisssion(){
		MM mm = MMUtil.getMM();
		ModelAndView modelAndView = new ModelAndView();
		if(mm.get("id") !=null){
			mm.put("c_tb", "sysRolePermission");
			Object commonGetDataById = commonService.commonGetDataById();
			List<Map<String, Object>> data = platSysService.SelectPermissionRoleList();
			modelAndView.addObject("data",data );
			modelAndView.addObject("object",commonGetDataById );
		}
		modelAndView.setViewName("/plat/sys/permissionrole");
		return modelAndView;
		
	}
}
