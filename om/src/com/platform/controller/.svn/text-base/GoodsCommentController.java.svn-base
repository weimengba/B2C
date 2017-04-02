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
@RequestMapping("/plat/goodsComment")
public class GoodsCommentController  extends BasePlatController{

	
	
/**
 * 进入商品分类列表
 */
	@RequestMapping("/goodsCommentList")
	public ModelAndView goodsCommentList() {

		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platGoodsCommentSevice.selectGoodsComment();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);
		
		mav.setViewName("/plat/goodsComment/goodsComment");
		return mav;
	}
	
	
		@RequestMapping("/goodsCommentDelete")
		public ModelAndView goodsCommentDelete() {
			MM mm = MMUtil.getMM();
			ModelAndView mav = new ModelAndView();
			if (mm.get("id") != null) {
				mm.put("c_tb", "goodsComment");
				Object data = commonService.updateCommonDeleteById();
			}
			mav.setViewName("redirect:goodsCommentList.do");
			return mav;
		}
		
	
}	
