package com.pub.service;

import java.util.List;
import java.util.Map;




/**
 * 商品业务接口
 * 
 * @author Administrator
 * 
 */
public interface PubGoodsServiceI {
	
	/**
	 * 根据ID查询GoodsDetail数据
	 * 
	 * @param param
	 * @return
	 */
	Map<String, Object> getGoodsDetailById();
	
	/**
	 * 根据ID查询GoodsDetail数据
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> findGoodsDetail();
	
	/**
	 * 根据categoryId查询Goods数据
	 * 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> findGoods();
	
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
	 * 添加Goods数据
	 * 
	 * @param param
	 * @return
	 */
	 int insertGoods();
	 
	 /**
	  * 查询GoodsComment所有数据
	  * 
	  * @param param
	  * @return
	  */
	List<Map<String, Object>> selectGoodsComment();
	
	/**
	 * 添加GoodsCommnet数据
	 * 
	 * @param param
	 * @return
	 */
	 int insertGoodsComment();
	 
	 /**
	  * 根据条件查询GoodsComment所有数据
	  * 
	  * @param param
	  * @return
	  */
	List<Map<String, Object>> selectGoodsCommentByGoodsId();
	 
	
}
