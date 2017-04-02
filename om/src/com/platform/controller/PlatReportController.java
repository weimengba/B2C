package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.MMUtil;

/**
 * 平台报表统计
 * @author 苏鹏
 *
 */

@Controller
@RequestMapping("/plat/report")
public class PlatReportController extends BasePlatController {

	
	/**
	 * 报表 销售排行
	 * @return 返回到 列表 页面
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/salesRank")
	public ModelAndView orderList(){
		ModelAndView mav=new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platReportService.selectSalesRank();
		PageInfo page = new PageInfo(data);
		mav.addObject("data",page);
		mav.setViewName("/plat/report/salesRank");
		return mav;
	}
}