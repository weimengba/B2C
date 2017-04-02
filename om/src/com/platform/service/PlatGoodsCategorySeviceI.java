package com.platform.service;

import java.util.List;
import java.util.Map;

/**
 * 管理后台商品分类service类。
 * 
 * @author Administrator
 * 
 */


public interface PlatGoodsCategorySeviceI{

	/**
	 * 公众前台商品分类查询。
	 * 
	 * @author Administrator
	 * 
	 */
	List<Map<String, Object>> selectGoodsCategory();

	/**
	 * 添加GoodsCategory数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	void insertGoodsCategory();
	
	/**
	 * 修改GoodsCategory数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	void updateGoodsCategoryById();
	
	
}
