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
 * 管理平台订单Controller控制器
 * @author sqy
 *
 */
@Controller
@RequestMapping("/plat/payment")
public class PlatOrderPaymentController extends BasePlatController {
	/**
	 * 该方法用于接受浏览器*.do请求，返回订单查询数据
	 * @return 查询视图
	 */
	@RequestMapping("/paymentList")
	public ModelAndView selectPlatOrderPayment(){
		//从本地线程变量获取MM并存储mm
		MM mm = MMUtil.getMM();		 
		//springMVC创建视图对象
		ModelAndView mav = new ModelAndView();
		//获取到分页参数PageHelper.startPage(pageNum, pageSize); 
		//pageNum(第几页) 和 pageSize(每页显示几条记录) 两个参数。
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		//获得查询结果集data
		List<Map<String, Object>> data = platOrderService.selectPlatOrderPayment();
		//创建并初始化PageInfo对象传入查询结果集data
		PageInfo page = new PageInfo(data);
		//将分页处理后的查询结果集放入视图中
		mav.addObject("data", page);
		mav.setViewName("/plat/payment/platPaymentList");
		return mav;	//返回视图	
	}
	
	/**
	 * 该方法用于返回添加请求的jsp页面
	 * @return
	 */
	@RequestMapping("/add")
	public String findPlatAddJsp(){	

		return "/plat/payment/platPaymentSave";		
	}
	
	/**
	 * 该方法用于添加平台订单数据
	 * @return mav查询视图
	 */
	@RequestMapping("/platPaymentSave")
	public ModelAndView addPlatOrderPayment(){
		MM mm = MMUtil.getMM();  
		System.out.println("=============================id=="+mm.get("id"));
		
		if (mm.get("id") != null) {
			platOrderService.updatePlatOrderPayment();
			System.out.println("修改成功！");
		}else{
			platOrderService.insertPubOrderPayment();
			System.out.println("添加成功！");
		} 
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		//获得查询结果集data
		List<Map<String, Object>> data = platOrderService.selectPlatOrderPayment();
		//创建并初始化PageInfo对象传入查询结果集data
		PageInfo page = new PageInfo(data);
		//将分页处理后的查询结果集放入视图中
		mav.addObject("data", page);
		mav.setViewName("/plat/payment/platPaymentList");
		return mav;
		
	}
	
	/**
	 * 该方法用于删除平台订单数据
	 * @return mav查询视图
	 */
	@RequestMapping("/platPaymentDelete")
	public ModelAndView delPlatOrderPayment(){
		MM mm = MMUtil.getMM();
		 
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			 mm.put("c_tb", "orderPayment");
			Object data = commonService.updateCommonDeleteById();
			System.out.println("删除成功！");
		}	
		
		mav.setViewName("redirect:/plat/payment/paymentList.do");
		return mav;
		
	}
	
	/**
	 * 该方法用于修改平台订单数据
	 * @return mav查询视图
	 */
	@RequestMapping("/updatePlat")
	public ModelAndView updatePlatOrderPayment(){
		MM mm = MMUtil.getMM();	 
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "orderPayment");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
			}
		mav.setViewName("/plat/payment/platPaymentSave");
		return mav; 
	}
}
