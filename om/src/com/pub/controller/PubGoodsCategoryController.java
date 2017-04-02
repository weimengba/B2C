package com.pub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.AjaxMessage;
import com.util.MM;
import com.util.MMUtil;

@Controller
@RequestMapping("/pub/goodsCategory")
public class PubGoodsCategoryController extends BasePubController {
	
	/**
	 * 测试条件查询
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/goodsCategoryList")
	@ResponseBody
	public Object goodsCategoryList() {
		List<Map<String, Object>> data = pubGoodsCategoryService.selectGoodsCategory();
		Map result = new HashMap();
		result.put("page", data);
		AjaxMessage msg = new AjaxMessage();
		msg.setData(result);
		return msg;
	}

	
	
	

	

	
}
