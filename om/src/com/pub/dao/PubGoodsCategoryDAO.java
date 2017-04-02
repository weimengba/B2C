package com.pub.dao;

import java.util.List;
import java.util.Map;


/**
 * 公众前台商品分类DAO类。
 * 
 * @author Administrator
 * 
 */

public interface PubGoodsCategoryDAO {
	
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
	int insertGoodsCategory(Map<String, Object> param);
	
	/**
	 * 修改GoodsCategory数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	int updateGoodsCategoryById(Map<String, Object> param);
}


















