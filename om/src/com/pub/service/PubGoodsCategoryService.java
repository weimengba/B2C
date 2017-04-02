package com.pub.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


/**
 * 商品分类业务实现类
 * 
 * @author Administrator
 * 
 */

@Service
public class PubGoodsCategoryService extends BasePubService implements PubGoodsCategoryServiceI{

	@Override
	public List<Map<String, Object>> selectGoodsCategory() {
		List<Map<String, Object>> data = pubGoodsCategoryDAO.selectGoodsCategory();
		return data;
	}

	

	
}
