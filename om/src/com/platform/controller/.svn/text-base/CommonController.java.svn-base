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
@RequestMapping("/plat/common")
public class CommonController extends BasePlatController {

	/**
	 * 通用删除
	 * 
	 * @return
	 */
	@RequestMapping("/delete")
	public ModelAndView delete() {

		this.commonService.updateCommonDeleteById();

		//根据Referer重定向到列表页面。
		String referer = MMUtil.getHttpServletRequest().getHeader("Referer");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:" + referer);
		return mav;
	}

	
	/**
	 * 通用查询:根据ID，表名查询数据
	 * 
	 * @return
	 */
	@RequestMapping("/row")
	public ModelAndView row() {

		//TODO 这里需要谁来做一下下啦！
	
		this.commonService.updateCommonDeleteById();

		//根据Referer重定向到列表页面。
		String referer = MMUtil.getHttpServletRequest().getHeader("Referer");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:" + referer);
		return mav;
	}	
	
	
	/**
	 * 文件列表
	 * @return
	 */
	
	@RequestMapping("/fileList") 
	public ModelAndView selectListFile() {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = commonService.selectFile();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);
		mav.setViewName("/plat/common/fileList");
		return mav;
	}
	
	/**
	 * 删除file文件
	 * @return
	 */
	@RequestMapping("/deleteFile") 
	public ModelAndView deleteFile() {		
		MM mm = MMUtil.getMM();
		
		if (mm.get("id") != null) {
			mm.put("c_tb", "commonFile");
			Object data = commonService.updateCommonDeleteById();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/plat/common/fileList.do");
		return mav;
	}
	
	/**
	 * 添加或修改file信息
	 * @return
	 */
	@RequestMapping("/fileSave")
	public ModelAndView fileSave() {
		MM mm = MMUtil.getMM();				
		if (mm.get("id") != null) {
			commonService.updateFileById();
		}else{
			commonService.insertFile(mm);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/plat/common/fileList.do");
		return mav;
	}
	
	/**
	 * 添加或编码跳转
	 * @return
	 */
	@RequestMapping("/file")
	public ModelAndView getFile() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "commonFile");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.setViewName("/plat/common/file");
		return mav;
	}
	@RequestMapping("/logList") 
	public ModelAndView selectListLog() {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = commonService.selectLog();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);
		mav.setViewName("/plat/common/logList");
		return mav;
	}
	
}