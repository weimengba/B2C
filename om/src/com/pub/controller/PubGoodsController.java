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
@RequestMapping("/pub/goods")
public class PubGoodsController extends BasePubController {
	
	
	/**
	 * 测试条件查询
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/goodsDetailById")
	@ResponseBody
	public Object goodsDetailById() {
		
		List<Map<String, Object>> data = pubGoodsService.findGoodsDetail();
		List<Map<String, Object>> comment = pubGoodsService.selectGoodsCommentByGoodsId();
		Map result = new HashMap();
		result.put("data", data);
		result.put("datas", comment);
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
	@RequestMapping("/goodsById")
	@ResponseBody
	public Object goodsById() {
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = pubGoodsService.findGoods();
		
		Map result = new HashMap();
		PageInfo page = new PageInfo(data);
		result.put("datas", page);
		
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);
		return msg;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/goodsList")
	@ResponseBody
	public Object goodsList(String title) {
		MM mm = MMUtil.getMM();
		mm.put("title", title);
		List<Map<String, Object>> data = pubGoodsService.findGoodsDynamic(mm);

		Map result = new HashMap();
		result.put("page", data);
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);

		return msg;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/goods")
	@ResponseBody
	public Object goods() {

		Map result = new HashMap();
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);
		return msg;

	}
	
	
	/**
	 * 商品详情
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/goodsDetail")
	@ResponseBody
	public Object goodsDetail() {
		
		//1商品详情。
		Map<String, Object> goodsDetail = pubGoodsService.getGoodsDetailById();
		//2商品评论。
		List<Map<String, Object>> comment = pubGoodsService.selectGoodsCommentByGoodsId();
		//3商品属性。
		List<Map<String, Object>> attr = pubGoodsService.selectGoodsCommentByGoodsId();
		
		
		Map result = new HashMap();
		result.put("goodsDetail", goodsDetail);
		result.put("comment", comment);
		result.put("attr", attr);
		
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);
		return msg; 
	}
	
	

}
