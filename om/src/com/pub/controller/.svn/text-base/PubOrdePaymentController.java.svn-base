package com.pub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.AjaxMessage;
import com.util.MMUtil;

/**
 * 订单支付信息Controller 
 * @author sqy
 *
 */
@Controller
@RequestMapping("/order")
public class PubOrdePaymentController extends BasePubController{
	@RequestMapping("/payment")
	@ResponseBody
	public Object goods() {
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		MMUtil.getMM().put("customerId", "2");
		List data = pubOrderPaymentServiceI.selectPubOrderList();		
		//PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());		 
		PageInfo page = new PageInfo(data);
		Map result = new HashMap();
		result.put("page", page);
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);
		System.out.println(result);
		System.out.println(msg.getMessage());
		return msg;
	}
	
	@RequestMapping("orderAll")
	public Object orderAll(){
		
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		//List data = pubOrderPaymentService
		
		return null;
	}


}
