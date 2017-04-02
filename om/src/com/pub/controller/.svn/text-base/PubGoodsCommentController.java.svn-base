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
import com.util.MM;
import com.util.MMUtil;

@Controller
@RequestMapping("/pub/goodsComment")
public class PubGoodsCommentController extends BasePubController {
	
	/**
	 * 测试条件查询
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/goodsCommentList")
	@ResponseBody
	public Object goodsCommentList() {
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = pubGoodsService.selectGoodsComment();
		PageInfo page = new PageInfo(data);
		Map result = new HashMap();
		result.put("page", page);
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);
		return msg;
	}
	
	/**
	 * 测试条件查询
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/goodsCommentById")
	@ResponseBody
	public Object goodsCommentById() {
		//MM mm = MMUtil.getMM();
		//mm.put("goodsId", id);
		List<Map<String, Object>> data = pubGoodsService.selectGoodsCommentByGoodsId();
		Map result = new HashMap();
		result.put("data", data);
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);
		return msg;
	}

	
	
	

	

	
}
