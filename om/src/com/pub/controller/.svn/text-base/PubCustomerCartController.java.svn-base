package com.pub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.AjaxMessage;
import com.util.MM;
import com.util.MMUtil;
import com.util.SysUtil;

@Controller
@RequestMapping("/cart")
public class PubCustomerCartController extends BasePubController {

	@RequestMapping("/customercart")
	@ResponseBody
	public Object customercart() {
		 MM mm=MMUtil.getMM();	
		 mm.put("customer_id", 2);
		 PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		 List data = pubCustomerService.selectListCustomerCart();
		 PageInfo page = new PageInfo(data);
		 return page;
		 
	}
}
