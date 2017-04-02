package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.util.MM;
import com.util.MMUtil;

/**
 * 管理后台商品分类service类。
 * 
 * @author Administrator
 * 
 */
@Service
public class PlatGoodsCategorySevice extends BasePlatService implements PlatGoodsCategorySeviceI{

	@Override
	public List<Map<String, Object>> selectGoodsCategory() {
		MM mm = MMUtil.getMM();
		Object name = mm.get("name");
	     List<Map<String, Object>> data = platGoodsCategoryDAO.selectGoodsCategory(mm);
		return data;
	}

	@Override
	public void insertGoodsCategory() {
		MM mm = MMUtil.getMM();
	 platGoodsCategoryDAO.insertGoodsCategory(mm);
		
	}

	@Override
	public void updateGoodsCategoryById() {
		MM mm = MMUtil.getMM();
		platGoodsCategoryDAO.updateGoodsCategoryById(mm);
	
	}
	
	
	
}
