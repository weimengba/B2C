package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.platform.dao.PlatOrderItemDAO;
import com.util.MM;
import com.util.MMUtil;

@Controller
@RequestMapping("/plat/order")
public class PlatOrderController extends BasePlatController {

	
	/**
	 * 查询所有订单或者按条件查询
	 * @return 返回到 列表 页面
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/orderList")
	public ModelAndView orderList(){
		ModelAndView mav=new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platOrderService.selectOrder();
		PageInfo page = new PageInfo(data);
		mav.addObject("data",page);
		mav.setViewName("/plat/order/orderList");
		return mav;
	}

	/**
	 * 平台编辑时拿回需要编辑数据
	 * @return 返回编辑页面
	 */
	@RequestMapping("/fetchOrder")
	public ModelAndView fetchOrder() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "order");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.setViewName("/plat/order/fetchOrder");
		return mav;
	}
	
	/**
	 * 平台 添加订单后保存
	 * @return 重定向到列表页面
	 */
	@RequestMapping("/orderSave")
	public ModelAndView orderSave() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		platOrderService.insertOrder();
		//redirect 重定向 .do
		mav.setViewName("redirect:/plat/order/orderList.do");
		return mav;
	}
	
	/**
	 * 平台 编辑订单后保存
	 * @return 重定向到列表页面
	 */
	@RequestMapping("/orderEdit")
	public ModelAndView orderEdit() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		platOrderService.updateOrderById();
		//redirect 重定向 .do
		mav.setViewName("redirect:/plat/order/orderList.do");
		return mav;
	}
	
	/**
	 * 平台订单删除
	 */
	@RequestMapping("/orderDelete")
	public ModelAndView orderDelete() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "order");
			Object data = commonService.updateCommonDeleteById();
		}
		mav.setViewName("redirect:/plat/order/orderList.do");
		return mav;
	}
	/**
	 * 订单详情表查询
	 */
	@RequestMapping("/OrderItemList")
	public ModelAndView SelectOrderItem() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data =platOrderService.selectOrderItem();
		PageInfo page = new PageInfo(data);
		mav.addObject("data",page);
		mav.setViewName("/plat/order/orderItemList");
		return mav;
	}
}