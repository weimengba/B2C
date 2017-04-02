package com.platform.dao;

import java.util.List;
import java.util.Map;

import com.util.MM;

/**
 * 管理后台商品分类DAO类。
 * 
 * @author Administrator
 * 
 */

public interface PlatGoodsCategoryDAO {

	/**
	 * 公众前台商品分类查询。
	 * 
	 * @author Administrator
	 * @param mm 
	 * 
	 */
	List<Map<String, Object>> selectGoodsCategory(MM mm);

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
