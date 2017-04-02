package com.platform.dao;

import java.util.List;
import java.util.Map;

import com.util.MM;

/**
 * 管理后台商品DAO类。
 * 
 * @author Administrator
 * 
 */

public interface PlatGoodsDAO {
	/**
	 * 查询所有的商品。
	 * 
	 */
	List<Map<String,Object>> selectGoods();
	
	/**
	 * 添加一个商品。
	 * @param map 
	 * 
	 */
	 int insertGoods(Map<String, Object> map);
	 
	 /**
		 * 修改商品。
		 * @param map 
		 * 
		 */
	 int updateGoodsById(Map<String, Object> map);

	List<Map<String, Object>> selectGoods(MM mm);
	 /**
	 * 查询商品图片
	 * @param mm 
	 */
	List<Map<String,Object>> selectGoodsPhoto(MM mm);
	 int goodsDeletePhoto(Map<String, Object> map);
	 List<Map<String, Object>> selectGoodsById(MM mm);
}
