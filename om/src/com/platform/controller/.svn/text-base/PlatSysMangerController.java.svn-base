package com.platform.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.MM;
import com.util.MMUtil;

@Controller
@RequestMapping("/plat/sys")
public class PlatSysMangerController extends BasePlatController {
	/**
	 * 用户登录
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView LoginCheck(HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/plat/sys/login");
		String loginId = getCookie("OM_LOGIN"); 
		if (loginId == null || "".equals(loginId)) {
			if (MMUtil.getMM().containsKey("account")) {
				List<Map<String, Object>> data = platSysService
						.selectLoginCheck();
				if (data != null && data.size() > 0) {

					// 把用户ID存储到会话对象中。
					MMUtil.getHttpServletRequest().getSession()
							.setAttribute("c_mid", data.get(0).get("id"));
					

					String random = UUID.randomUUID().toString()
							.replace("-", "");
					//设置服务端Token过期时间。
					data.get(0).put("expireTime", new Date());		
					
					redisDAO.setLoginUser(random.toString(), data.get(0));
					Cookie loginCookie = new Cookie("OM_LOGIN", random);
					loginCookie.setMaxAge(60 * 60 * 24 * 30);// 设置cookie时长一个月
					response.addCookie(loginCookie);
					mav.addObject("userys", data.get(0));
					mav.setViewName("redirect:/plat/goods/goodsList.do");
				}
			}
		} else {
			Map<String, String> data = redisDAO.getLoginUser(loginId);
			//设置管理员会话ID
			MMUtil.getHttpServletRequest().getSession()
			.setAttribute("c_mid", data.get("id"));
			
			mav.addObject("user", data);
			mav.setViewName("redirect:/plat/goods/goodsList.do");
		}
		return mav;
	}

	/**
	 * 注销登录
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String loginId = getCookie("OM_LOGIN");
		if (!"".equals(loginId)) {
			MMUtil.getHttpServletRequest().getSession().invalidate();
			redisDAO.delLoginUser(loginId);
			delCookie("OM_LOGIN", response);
		}
		mav.setViewName("redirect:/plat/sys/login.do");
		return mav;
	}

	/**
	 * 管理员列表
	 * 
	 * @return
	 */
	@RequestMapping("/managerList")
	public ModelAndView sysManagerList() {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platSysService
				.selectListPlaySysManger();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);

		mav.setViewName("/plat/sys/sysManagerList");
		return mav;
	}

	/**
	 * 添加或修改管理员跳转
	 * 
	 * @return
	 */
	@RequestMapping("/sysManager")
	public ModelAndView sysManager() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "sysRolePermission");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.setViewName("/plat/sys/sysManager");
		return mav;
	}

	/**
	 * 提交修改或添加管理员
	 * 
	 * @return
	 */
	@RequestMapping("/sysManagerSave")
	public ModelAndView sysManagerSave() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();

		if (mm.get("id") != null) {
			platSysService.updateSysManger();
		} else {
			platSysService.insertSysManger();
		}

		mav.setViewName("redirect:/plat/sys/managerList.do");
		return mav;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping("/deleteSysManager")
	public ModelAndView sysManagerDelete() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "sysManager");
			Object data = commonService.updateCommonDeleteById();
		}
		mav.setViewName("redirect:/plat/sys/managerList.do");
		return mav;
	}

	/**
	 * 权限
	 * 
	 * @return
	 */
	@RequestMapping("/permissionList")
	public ModelAndView permission() {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());

		List<Map<String, Object>> data = platSysService.selectSysPermission();

		PageInfo page = new PageInfo(data);

		mav.addObject("data", page);

		mav.setViewName("/plat/sys/permissionList");
		return mav;
	}

	/**
	 * 添加或修改权限
	 * 
	 * @return
	 */
	@RequestMapping("/sysPermission")
	public ModelAndView sysPermission() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "sysPermission");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.setViewName("/plat/sys/permission");
		return mav;
	}

	/**
	 * 提交修改或添加权限
	 * 
	 * @return
	 */
	@RequestMapping("/sysPermissionSave")
	public ModelAndView sysPermissionSave() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();

		if (mm.get("id") != null) {
			platSysService.updateSysPermission();
		} else {
			platSysService.insertSysPermission();
		}

		mav.setViewName("redirect:/plat/sys/permissionList.do");
		return mav;
	}

	/**
	 * 修改权限
	 * 
	 * @return
	 */
	@RequestMapping("/sysPermissionDelete")
	public ModelAndView sysPermissionDelete() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "sysPermission");
			Object data = commonService.updateCommonDeleteById();
		}
		mav.setViewName("redirect:/plat/sys/permissionList.do");
		return mav;
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@RequestMapping("/managerRoleList")
	public ModelAndView mangerRole() {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());

		List<Map<String, Object>> data = platSysService.selectSysMangerRole();

		PageInfo page = new PageInfo(data);

		mav.addObject("data", page);

		mav.setViewName("/plat/sys/managerRoleList");
		return mav;
	}

	@RequestMapping("/managerRole")
	public ModelAndView managerRole() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "sysManager_role");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.setViewName("/plat/sys/managerRole");
		return mav;
	}

	@RequestMapping("/managerRoleSave")
	public ModelAndView managerRoleSave() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();

		if (mm.get("id") != null) {
			// platSysService.updateManagerRole();
			platSysService.insertManagerRole();
		}

		mav.setViewName("redirect:/plat/sys/managerRoleList.do");
		return mav;
	}

}
