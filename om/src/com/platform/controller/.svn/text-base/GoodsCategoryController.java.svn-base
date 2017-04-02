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
@RequestMapping("/plat/goodsCategory")
public class GoodsCategoryController  extends BasePlatController{

	
	
/**
 * 进入商品分类列表
 */
	@RequestMapping("/goodsCategoryList")
	public ModelAndView goodsList() {

		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platGoodsCategorySevice.selectGoodsCategory();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);
		
		mav.setViewName("/plat/goodsCategory/goodsCategoryList");
		return mav;
	}
	
	/**
	 * 判断是添加还是编辑商品分类
	 */
	@RequestMapping("/goodsCategory")
	public ModelAndView goods(){
		MM mm = MMUtil.getMM();
		Object id = mm.get("id");
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "goodsCategory");
			Object goodsCategory = platGoodsCategorySevice.selectGoodsCategory();
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
			mav.addObject("goodsCategory", goodsCategory);
		}else{
			mm.put("c_tb", "goodsCategory");
			Object goodsCategory = platGoodsCategorySevice.selectGoodsCategory();
			mav.addObject("goodsCategory", goodsCategory);
		}
		mav.setViewName("/plat/goodsCategory/goodsCategory");
		return mav;
      
	} 
	/**
	 * 添加编辑商品分类
	 */
		@RequestMapping("/goodsCategorySave")
		public ModelAndView goodsCategorySave() {
			MM mm = MMUtil.getMM();
			if (mm.get("id") != null) {
				platGoodsCategorySevice.updateGoodsCategoryById();
			}else{
				platGoodsCategorySevice.insertGoodsCategory();
			}
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect: goodsCategoryList.do");
			return mav;
		}
		
		@RequestMapping("/goodsCategoryDelete")
		public ModelAndView goodsCategoryDelete() {
			MM mm = MMUtil.getMM();
			ModelAndView mav = new ModelAndView();
			if (mm.get("id") != null) {
				mm.put("c_tb", "goodsCategory");
				Object data = commonService.updateCommonDeleteById();
			}
			mav.setViewName("redirect:goodsCategoryList.do");
			return mav;
		}
		
	
}	
