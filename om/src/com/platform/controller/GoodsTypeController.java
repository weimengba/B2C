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
@RequestMapping("/plat/goodsType")
public class GoodsTypeController  extends BasePlatController{

	
	
	/**
	 * 查询商品类别
	 */
	@RequestMapping("/goodsTypeList")
	public ModelAndView goodsTypeList() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platGoodsTypeSevice.selectGoodsType();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);

		mav.setViewName("/plat/goodsType/goodsTypeList");
		return mav;
	}
	
	/**
	 * 判断是添加还是编辑商品类别
	 */
	@RequestMapping("/goodsType")
	public ModelAndView goodsType() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "goodsType");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}
		mav.setViewName("/plat/goodsType/goodsType");
		return mav;
	}
	
		/**
		 * 保存商品类别
		 */
	@RequestMapping("/goodsTypeSave")
	public ModelAndView goodsTypeSave() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		
		if (mm.get("id") != null) {
			platGoodsTypeSevice.updateGoodsTypeById();
		}else{
			platGoodsTypeSevice.insertGoodsType();
		}

		mav.setViewName("redirect:/plat/goodsType/goodsTypeList.do");
		return mav;
	}
		
		/**
		 * 删除商品类别
		 * @return
		 */
	@RequestMapping("/goodsTypeDelete")
	public ModelAndView goodsTypeDelete() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "goodsType");
			Object data = commonService.updateCommonDeleteById();
		}
		mav.setViewName("redirect:/plat/goodsType/goodsTypeList.do");
		return mav;
	}
		
	
		
	
}	
