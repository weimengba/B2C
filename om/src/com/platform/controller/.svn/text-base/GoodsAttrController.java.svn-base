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
@RequestMapping("/plat/goodsAttr")
public class GoodsAttrController  extends BasePlatController{

	
	
/**
 * 进入商品分类列表
 */
	@RequestMapping("/goodsAttrList")
	public ModelAndView goodsAttrList() {

		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platGoodsAttrSevice.selectGoodsAttr();

		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);
		
		mav.setViewName("/plat/goodsAttr/goodsAttrList");
		return mav;
	}
	
	/**
	 * 判断是添加还是编辑商品分类
	 */
	@RequestMapping("/goodsAttr")
	public ModelAndView goodsAttr(){
		MM mm = MMUtil.getMM();
		Object id = mm.get("id");
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "goodsAttr");
			Object goodsType = platGoodsTypeSevice.selectGoodsType();
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
			mav.addObject("goodsType", goodsType);
		}else{
			mm.put("c_tb", "goodsAttr");
			Object goodsType = platGoodsTypeSevice.selectGoodsType();
			mav.addObject("goodsType", goodsType);
		}
		mav.setViewName("/plat/goodsAttr/goodsAttr");
		return mav;
      
	} 
	/**
	 * 添加编辑商品分类
	 */
		@RequestMapping("/goodsAttrSave")
		public ModelAndView goodsAttrSave() {
			MM mm = MMUtil.getMM();
			if (mm.get("id") != null) {
				platGoodsAttrSevice.updateAttrById();
			}else{
				platGoodsAttrSevice.insertAttr();
			}
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect: goodsAttrList.do");
			return mav;
		}
		
		@RequestMapping("/goodsAttrDelete")
		public ModelAndView goodsAttrDelete() {
			MM mm = MMUtil.getMM();
			ModelAndView mav = new ModelAndView();
			if (mm.get("id") != null) {
				mm.put("c_tb", "goodsAttr");
				Object data = commonService.updateCommonDeleteById();
			}
			mav.setViewName("redirect:goodsAttrList.do");
			return mav;
		}
		
	
}	
