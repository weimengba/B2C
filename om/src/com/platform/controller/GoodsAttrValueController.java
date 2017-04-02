package com.platform.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.MM;
import com.util.MMUtil;


@Controller
@RequestMapping("/plat/goodsAttrValue")
public class GoodsAttrValueController  extends BasePlatController{

	
	
	/**
	 * 查询商品类别
	 */
	@RequestMapping("/goodsAttrValueList")
	public ModelAndView goodsAttrValueList() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platGoodsAttrValueSevice.selectGoodsAttrValue();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);

		mav.setViewName("/plat/goodsAttrValue/goodsAttrValueList");
		return mav;
	}
	
	/**
	 * 判断是添加还是编辑商品类别
	 */
	@RequestMapping("/goodsAttrValue")
	public ModelAndView goodsAttrValue() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "goodsAttrCalue");
			Object goods = platGoodsSevice.selectGoods();
			Object goodsAttr = platGoodsAttrSevice.selectGoodsAttr();
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
			mav.addObject("goods", goods);
			mav.addObject("goodsAttr", goodsAttr);
			mav.setViewName("/plat/goodsAttrValue/goodsAttrValueEdit");
		}else{
			mm.put("c_tb", "goodsAttrCalue");
			Object goods = platGoodsSevice.selectGoods();
			Object goodsAttr = platGoodsAttrSevice.selectGoodsAttr();
			mav.addObject("goods", goods);
			mav.addObject("goodsAttr", goodsAttr);
			mav.setViewName("/plat/goodsAttrValue/goodsAttrValue");
		}
		return mav;
	}
	
		/**
		 * 保存商品类别
		 */
	@RequestMapping("/goodsAttrValueSave")
	public ModelAndView goodsAttrValueSave() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		
		if (mm.get("id") != null) {
			platGoodsAttrValueSevice.updateAttrValueById();
		}else{
			platGoodsAttrValueSevice.insertAttrValue();
		}

		mav.setViewName("redirect:/plat/goodsAttrValue/goodsAttrValueList.do");
		return mav;
	}
		
		/**
		 * 删除商品类别
		 * @return
		 */
	@RequestMapping("/goodsAttrValueDelete")
	public ModelAndView goodsAttrValueDelete() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "goodsAttrCalue");
			Object data = commonService.updateCommonDeleteById();
		}
		mav.setViewName("redirect:/plat/goodsAttrValue/goodsAttrValueList.do");
		return mav;
	}
		
	@SuppressWarnings("unchecked")
	@RequestMapping("/goodsAttrChange")
	@ResponseBody
	public Object goodsAttrChange(int id) {
		Map map = new HashMap<>();
		List<Map<String,Object>> list = platGoodsSevice.selectGoodsById(id);
		
		Map<String, Object> map2 = list.get(0);
		Object typeId = map2.get("type_id");
		List<Map<String,Object>> list2 = platGoodsAttrSevice.selectGoodsAttrByTypeId(typeId);
		map.put("attr", list2);
		map.put("message", "success");
		System.out.println(map);
		return map;
	} 
		
	
}	
