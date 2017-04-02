package com.pub.dao;

import java.util.List;
import java.util.Map;

import com.util.MM;

/**
 * 公众前台商品DAO类。
 * 
 * @author Administrator
 * 
 */

public interface PubGoodsDAO {

	/**
	 * 根据ID查询GoodsDetail数据
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> findGoodsDetail(Map<String, Object> param);

	/**
	 * 根据categoryId查询Goods数据
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> findGoods(MM mm);

	/**
	 * 条件查询Goods数据
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> findGoodsDynamic(Map<String, Object> param);

	/**
	 * 查询Goods所有数据
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectGoods();

	/**
	 * 添加Goods数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	int insertGoods(Map<String, Object> param);

	/**
	 * 修改Goods数据(根据参数做选择)
	 * 
	 * @param param
	 * @return
	 */
	int updateGoodsById(Map<String, Object> param);

	/**
	 * 根据ID查询商品详情
	 * @param param
	 * @return
	 */
	Map<String, Object> getGoodsDetailById(Map<String, Object> param);
}
