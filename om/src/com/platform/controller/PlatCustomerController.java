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
@RequestMapping("/plat/customer")
public class PlatCustomerController extends BasePlatController {
	
	/**
	 * 所有客户列表
	 * @return
	 */
	@RequestMapping("/customerList") 
	public ModelAndView selectListCustomer() {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platCustomerService.selectListCustomer();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);
		mav.setViewName("/plat/customer/customerList");
		return mav;
	}
	
	/**
	 * 删除客户
	 * @return
	 */
	@RequestMapping("/deleteCustomer") 
	public ModelAndView deleteCustomer() {		
		MM mm = MMUtil.getMM();
		if (mm.get("id") != null) {
			mm.put("c_tb", "customer");
			Object data = commonService.updateCommonDeleteById();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/plat/customer/customerList.do");
		return mav;
	}
	
	/**
	 * 添加或编码跳转
	 * @return
	 */
	@RequestMapping("/customer")
	public ModelAndView sysManager() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "customer");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.setViewName("/plat/customer/customer");
		return mav;
	}
	
	/**
	 * 添加或修改提交客户信息
	 * @return
	 */
	@RequestMapping("/customerSave")
	public ModelAndView customerSave() {
		MM mm = MMUtil.getMM();				
		if (mm.get("id") != null) {
			platCustomerService.updateCustomer();
		}else{
			platCustomerService.insertCustomer();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/plat/customer/customerList.do");
		return mav;
	}
	
	/**
	 * 当前客户收货地址列表
	 * @return
	 */
	@RequestMapping("/addressList") 
	public ModelAndView selectListCustomerAddress() {
		ModelAndView mav = new ModelAndView();
		MM mm = MMUtil.getMM();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platCustomerService.selectListCustomerAddress();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);
		mav.addObject("customerId", mm.get("customerId"));
		mav.setViewName("/plat/customer/customerAddressList");
		return mav;
	}
	
	/**
	 * 删除收货地址
	 * @return
	 */
	@RequestMapping("/deleteAddress")
	public ModelAndView updateDeleteCustomerAddress() {
		MM mm = MMUtil.getMM();
		mm.put("c_tb", "customerAddress");
		commonService.updateCommonDeleteById();
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerId", mm.get("customerId"));
		mav.setViewName("redirect:/plat/customer/addressList.do");
		return mav;
	}
	
	/** 
	 * 修改或增加收货地址
	 * @return
	 */
	@RequestMapping("/address")
	public ModelAndView address() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "customerAddress");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.addObject("customerId", mm.get("customerId"));
		mav.setViewName("/plat/customer/customerAddress");
		return mav;
	}
	
	/**
	 * 添加或修改提交收货地址
	 * @return
	 */
	@RequestMapping("/addressSave")
	public ModelAndView addressSave() {
		MM mm = MMUtil.getMM();				
		if (mm.get("id") != null) {
			platCustomerService.updateCustomerAddress();
		}else{
			platCustomerService.insertCustomerAddress();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerId", mm.get("customerId"));
		mav.setViewName("redirect:/plat/customer/addressList.do");
		return mav;
	}
	
	/**
	 * 当前客户购物车列表
	 * @return
	 */
	@RequestMapping("/cartList") 
	public ModelAndView selectListCustomerCart() {
		ModelAndView mav = new ModelAndView();
		MM mm = MMUtil.getMM();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platCustomerService.selectListCustomerCart();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);
		mav.addObject("customerId", mm.get("customerId"));
		mav.setViewName("/plat/customer/customerCartList");
		return mav;
	}
	
	/**
	 * 删除购物车
	 * @return
	 */
	@RequestMapping("/deleteCart")
	public ModelAndView updateDeleteCustomerCart() {
		MM mm = MMUtil.getMM();
		mm.put("c_tb", "customerCart");
		commonService.updateCommonDeleteById();
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerId", mm.get("customerId"));
		mav.setViewName("redirect:/plat/customer/cartList.do");
		return mav;
	}
	
	/** 
	 * 修改或增加购物车
	 * @return
	 */
	@RequestMapping("/cart")
	public ModelAndView cart() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "customerCart");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.addObject("customerId", mm.get("customerId"));
		mav.setViewName("/plat/customer/customerCart");
		return mav;
	}
	
	/**
	 * 添加或修改提交购物车
	 * @return
	 */
	@RequestMapping("/cartSave")
	public ModelAndView cartSave() {
		MM mm = MMUtil.getMM();				
		if (mm.get("id") != null) {
			platCustomerService.updateCustomerCartNum();
		}else{
			platCustomerService.insertCustomerCart();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerId", mm.get("customerId"));
		mav.setViewName("redirect:/plat/customer/cartList.do");
		return mav;
	}
}
