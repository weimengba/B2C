package com.platform.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.MM;
import com.util.MMUtil;
import com.util.SysUtil;

@Controller
@RequestMapping("/plat/goods")
public class GoodsController extends BasePlatController {

	/**
	 * 进入商品列表
	 */
	@RequestMapping("/goodsList")
	public ModelAndView goodsList() {

		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(MMUtil.getCurrent(), MMUtil.getPageSize());
		List<Map<String, Object>> data = platGoodsSevice.selectGoods();
		PageInfo page = new PageInfo(data);
		mav.addObject("data", page);

		mav.setViewName("/plat/goods/goodsList");
		return mav;
	}
	
	/**
	 * 进入详情列表
	 */
	@RequestMapping("/goodsDetailList")
	public ModelAndView goodsDetail() {
		MM mm = MMUtil.getMM();
		Object id = mm.get("id");

		// 获取商品类型。
		
		// 获取商品类别。

		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "goods");
			Object data = commonService.commonGetDataById();
			mav.addObject("object", data);
		}

		mav.setViewName("/plat/goods/goodsDetailList");
		return mav;
	}

	/**
	 * 判断是添加还是编辑
	 */
	@RequestMapping("/goods")
	public ModelAndView goods() {
		MM mm = MMUtil.getMM();
		Object id = mm.get("id");

		// 获取商品类型。
		
		// 获取商品类别。

		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "goods");
			Object data = commonService.commonGetDataById();
			Object photo = platGoodsSevice.selectGoodsPhoto();
			Object goodsCat = platGoodsCategorySevice.selectGoodsCategory();
			Object goodsType = platGoodsTypeSevice.selectGoodsType();
			Object goodsImg = platGoodsSevice.selectGoodsImg();
			mav.addObject("goodsImg", goodsImg);
			mav.addObject("goodsType", goodsType);
			mav.addObject("goodsCat", goodsCat);
			mav.addObject("o", photo);
			mav.addObject("object", data);
		}else{
			mm.put("c_tb", "goods");
			Object goodsCat = platGoodsCategorySevice.selectGoodsCategory();
			Object goodsType = platGoodsTypeSevice.selectGoodsType();
			mav.addObject("goodsType", goodsType);
			mav.addObject("goodsCat", goodsCat);
		}
		mav.setViewName("/plat/goods/goods");
		return mav;

	}

	/**
	 * 添加编辑保存商品
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/goodsSave")
	public ModelAndView goodsSave(
			@RequestParam("goodsPhoto") MultipartFile[] goodsPhoto,
			@RequestParam("goodsImg") MultipartFile[] goodsImg,
			HttpServletRequest request) throws IOException {

		MM mm = MMUtil.getMM();
		if (mm.get("id") != null) {
			
			platGoodsSevice.updateGoodsById();
			String uploadImagePath = (String) SysUtil.getSysConfig().get(
					"SYS_UPLOAD_GOOD_IMAGE_DIR");
			commonSaveFile(goodsPhoto, uploadImagePath, mm.get("id"),
					"goodsPhoto");
			commonSaveFile(goodsImg, uploadImagePath, mm.get("id"), "goodsImg");

		} else {
			platGoodsSevice.insertGoods();

			String uploadImagePath = (String) SysUtil.getSysConfig().get(
					"SYS_UPLOAD_GOOD_IMAGE_DIR");
			commonSaveFile(goodsPhoto, uploadImagePath, mm.get("id"),
					"goodsPhoto");
			commonSaveFile(goodsImg, uploadImagePath, mm.get("id"), "goodsImg");
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect: goodsList.do");
		return mav;
	}

	@RequestMapping("/goodsDelete")
	public ModelAndView goodsDelete() {
		MM mm = MMUtil.getMM();
		ModelAndView mav = new ModelAndView();
		if (mm.get("id") != null) {
			mm.put("c_tb", "goods");
			Object data = commonService.updateCommonDeleteById();
		}
		mav.setViewName("redirect:goodsList.do");
		return mav;
	}
	//删除图片
	@RequestMapping("/goodsDeletePhoto")
	@ResponseBody
	public Object goodsDeletePhoto(String type ,int id) {
		
	
		Map map = new HashMap<>();
		map.put("message", "success");
		platGoodsSevice.goodsDeletePhoto( type , id);
		return map;
		
	}

}
