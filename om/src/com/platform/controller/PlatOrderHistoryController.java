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
 * 管理平台历史订单Controller控制器
 * @author sqy
 *
 */@Controller
 @RequestMapping("/plat/payment")
 public class PlatOrderHistoryController extends BasePlatController {
 	/**
 	 * 该方法用于接受浏览器*.do请求，返回订单查询数据
 	 * @return 查询视图
 	 */
 	@RequestMapping("/historyList")
 	public ModelAndView selectPlatOrderHistory(){
 		//从本地线程变量获取MM并存储mm
 		MM mm = MMUtil.getMM();		 
 		//springMVC创建视图对象
 		ModelAndView mav = new ModelAndView();
 		//获取到分页参数PageHelper.startPage(pageNum, pageSize); 
 		//pageNum(第几页) 和 pageSize(每页显示几条记录) 两个参数。
 		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
 		//获得查询结果集data
 		List<Map<String, Object>> data = platOrderService.selectPlatOrderHistory();
 		//创建并初始化PageInfo对象传入查询结果集data
 		PageInfo page = new PageInfo(data);
 		//将分页处理后的查询结果集放入视图中
 		mav.addObject("data", page);
 		mav.setViewName("/plat/history/historyList");
 		return mav;	//返回视图	
 	}
 	
 	/**
 	 * 该方法用于返回添加请求的jsp页面
 	 * @return
 	 */
 	@RequestMapping("/history")
 	public String findHistoryJsp(){	

 		return "/plat/history/historySave";		
 	}
 	
 	/**
 	 * 该方法用于添加平台订单数据
 	 * @return mav查询视图
 	 */
 	@RequestMapping("/historySave")
 	public ModelAndView addPlatOrderHistory(){
 		MM mm = MMUtil.getMM();  
 		System.out.println("=============================id=="+mm.get("id"));
 		
 		if (mm.get("id") != null) {
 			platOrderService.updatetPubOrderHistory();
 			System.out.println("修改成功！");
 		}else{
 			platOrderService.insertPubOrderHistory();
 			System.out.println("添加成功！");
 		} 
 		ModelAndView mav = new ModelAndView();
 		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
 		//获得查询结果集data
 		List<Map<String, Object>> data = platOrderService.selectPlatOrderHistory();
 		//创建并初始化PageInfo对象传入查询结果集data
 		PageInfo page = new PageInfo(data);
 		//将分页处理后的查询结果集放入视图中
 		mav.addObject("data", page);
 		mav.setViewName("/plat/history/historyList");
 		return mav;
 		
 	}
 	/**
	 * 该方法用于删除平台订单数据
	 * @return mav查询视图
	 */
	@RequestMapping("/historyDelete")
	public ModelAndView delPlatOrderHistory(){
		MM mm = MMUtil.getMM();
		 
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			 mm.put("c_tb", "orderHistory");
			Object data = commonService.updateCommonDeleteById();
			System.out.println("删除历史订单成功！");
		}	
		
		mav.setViewName("redirect:/plat/payment/historyList.do");
		return mav;
		
	}
	/**
	 * 该方法用于修改平台订单数据
	 * @return mav查询视图
	 */
	@RequestMapping("/updateHistory")
	public ModelAndView updatePlatOrderPayment(){
		MM mm = MMUtil.getMM();	 
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "orderHistory");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
			}
		mav.setViewName("/plat/history/historySave");
		return mav; 
	}
 }
