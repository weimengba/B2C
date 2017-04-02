package com.platform.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.util.SysUtil;

/**
 * 系统控制器用于开发阶段的系统配置。
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/plat/sys")
public class SysController extends BasePlatController {

	/**
	 * 显示验证框架的页面。
	 * 
	 * @return
	 */
	@RequestMapping("/validator")
	public ModelAndView validator() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/plat/sys/validator");
		return mav;
	}

	/**
	 * 获取验证框架的数据。
	 * 
	 * @return
	 */
	@RequestMapping("/getValidateData")
	@ResponseBody
	public Map getValidateData() {
		return JSON.parseObject(SysUtil
				.getJsonStringFromFile(SysUtil.validatorFileName));
	}

	/**
	 * 保存验证框架的数据。
	 * 
	 * @return
	 */
	@RequestMapping("/setValidateData")
	@ResponseBody
	public String setValidateData(String config) {
		SysUtil.saveJsonToFile(config, SysUtil.validatorFileName);
		return "success";
	}

	/**
	 * 显示系统数据字典的页面。
	 * 
	 * @return
	 */
	@RequestMapping("/sysdict")
	public ModelAndView sysdict() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/plat/sys/sysdict");
		return mav;
	}

	/**
	 * 获取数据字典的数据。
	 * 
	 * @return
	 */
	@RequestMapping("/getSysDict")
	@ResponseBody
	public Map getSysDict() {
		return JSON.parseObject(SysUtil
				.getJsonStringFromFile(SysUtil.sysDictFileName));
	}

	/**
	 * 保存数据字典的数据。
	 * 
	 * @return
	 */
	@RequestMapping("/setSysDict")
	@ResponseBody
	public String setSysDict(String config) {
		SysUtil.saveJsonToFile(config, SysUtil.sysDictFileName);
		return "success";
	}

	/**
	 * 显示系统设置 的页面。
	 * 
	 * @return
	 */
	@RequestMapping("/sysconfig")
	public ModelAndView sysconfig() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/plat/sys/sysconfig");
		return mav;
	}

	/**
	 * 获取系统设置的数据。
	 * 
	 * @return
	 */
	@RequestMapping("/getSysConfig")
	@ResponseBody
	public Map getSysConfig() {
		return JSON.parseObject(SysUtil
				.getJsonStringFromFile(SysUtil.sysConfigFileName));
	}

	/**
	 * 保存系统设置的数据。
	 * 
	 * @return
	 */
	@RequestMapping("/setSysConfig")
	@ResponseBody
	public String setSysConfig(String config) {
		SysUtil.saveJsonToFile(config, SysUtil.sysConfigFileName);
		return "success";
	}
}