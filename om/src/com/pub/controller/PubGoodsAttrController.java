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

@Controller
@RequestMapping("/pub/goodsAttr")
public class PubGoodsAttrController extends BasePubController {

	/**
	 * 测试条件查询
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/goodsAttrList")
	@ResponseBody
	public Object goodAttrsList() {

		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = pubGoodsTypeAttrService.selectGoodsAttr();
		PageInfo page = new PageInfo(data);

		Map result = new HashMap();
		result.put("page", page);
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);

		return msg;
	}

	

}
