package com.platform.service;

import java.util.List;
import java.util.Map;

/**
 * 管理后台商品service类。
 * 
 * @author Administrator
 * 
 */

public interface PlatGoodsSeviceI {
	List<Map<String, Object>> selectGoods();

	/**
	 * 添加
	 */
	void updateGoodsById();

	/**
	 * 修改
	 */
	void insertGoods();

	Object selectGoodsPhoto();
	Object selectGoodsImg();
	void goodsDeletePhoto(String type, int id);
	List<Map<String, Object>> selectGoodsById(int id);
}
