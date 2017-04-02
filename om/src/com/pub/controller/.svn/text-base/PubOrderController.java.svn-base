package com.pub.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.SystemUtils;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.service.PubOrderService;
import com.pub.service.PubOrderViewService;
import com.util.MM;
import com.util.MMUtil;
import com.util.SysUtil;

@Controller
@RequestMapping("/order")
public class PubOrderController extends BasePubController {

	
	/**
	 * 测试查询
	 * 
	 * @return
	 */
	@RequestMapping("/orderList")
	public ModelAndView t3() {
		MM mm = MMUtil.getMM();	
		System.out.println(mm.get("remark")); 
		ModelAndView mav = new ModelAndView();		
		PageHelper.startPage(MMUtil.getCurrent(),MMUtil.getPageSize());		
		List<Map<String, Object>> data = pubOrderService.selectOrder();
		PageInfo page=new PageInfo(data);
		mav.addObject("data", page);
		mav.setViewName("/pub/order/orderList");
		return mav;
	}
	@RequestMapping("/tianjia")
	public ModelAndView t4() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
			mm.put("c_tb", "order");
			Object data =commonService.commonGetDataById();
			mav.addObject("object", data);
		
		mav.setViewName("/pub/order/AddOrder");
		return mav;
	}
	@RequestMapping("/tianjia1")
	public ModelAndView t6() {
		ModelAndView mav = new ModelAndView();
		 mav.setViewName("/pub/order/AddOrder");		
		return mav;
	}
	@RequestMapping("/AddOrder")
	public ModelAndView t5() {
		MM mm = MMUtil.getMM();			
		ModelAndView mav = new ModelAndView();			
		if (mm.get("id") != null) {	
		  pubOrderService.updateOrderByid();
		}else{			   	
	 	  pubOrderService.insertOrder();	 
	     }		
		 mav.setViewName("redirect:/order/orderList.do");
		return mav;
	}	
	
	@RequestMapping("/DeleteOrder")
	public ModelAndView Delete() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "order");
			Object data = commonService.updateCommonDeleteById();
		}
		mav.setViewName("redirect:/order/orderList.do");
		return mav;
	}
	@RequestMapping("/OrderView")
	@ResponseBody  //转换成json
	public Object OrderView() {
	   MM mm=MMUtil.getMM();	
	   ModelAndView mav = new ModelAndView();
	   mm.put("customer_id", 20);	 
	    PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List data = pubOrderViewService.OrderView();	
		PageInfo page = new PageInfo(data);
		return page;
	   
	}
	
	@RequestMapping("/orderPay")
	@ResponseBody  //转换成json
	public Object orderPay() throws ServletException, IOException {
	   MM mm=MMUtil.getMM();	
	   mm.put("customerId", 2);
	   ModelAndView mav = new ModelAndView();
	   // List<Map<String, Object>> data = pubOrderService.selectCustomerCart();//购物车数据（总价，商品ID，数量 ，.....）	
	    boolean aa= pubOrderService.placeOrder();
	    if(aa==false){
	    	System.out.println("-------------------库存不足，跳往购物车页面");
	    }else{
	    	System.out.println("-------------------订单生成成功");
	    }
	   
	    /**
	     * 需要生成一个订单编号
	     */    
		/*int i = pubOrderService.insertOrder();	//添加订单  默认未支付状态
		if(i!=0){
				pubOrderItemService.insertOrderItemAll(data);	//添加购买商品详细				
		}*/
		//付款
		
		// 修改为已支付状态
		
		PageInfo page = new PageInfo();
		return page;
	   
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/addCar")
	@ResponseBody  //转换成json
	public Object addCar(){
		ModelAndView mav = new ModelAndView();
		int i= pubOrderService.insertCustomerCart();
		if(i>0){
			
		}else{
			
		}
		mav.setViewName("redirect:/order/orderList.do");
		return mav;
		
	}
	
}
