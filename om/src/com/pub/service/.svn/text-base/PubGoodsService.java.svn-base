package com.pub.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.util.MM;
import com.util.MMUtil;

/**
 * 商品业务实现类
 * 
 * @author Administrator
 * 
 */

@Service
public class PubGoodsService extends BasePubService implements PubGoodsServiceI {

	/**
	 * 查询Goods所有数据
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectGoods() {

		List<Map<String, Object>> data = pubGoodsDAO.selectGoods();
		return data;
	}

	/**
	 * 添加Goods数据
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int insertGoods() {
		System.out.println(MMUtil.getMM());
		return pubGoodsDAO.insertGoods(MMUtil.getMM());

	}

	/**
	 * 条件查询Goods所有数据
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findGoodsDynamic(Map<String, Object> param) {

		List<Map<String, Object>> data = pubGoodsDAO.findGoodsDynamic(param);
		return data;
	}

	/**
	 * 查询GoodsConment所有数据
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectGoodsComment() {
		List<Map<String, Object>> data = pubGoodsCommentDAO
				.selectGoodsComment();
		return data;
	}

	/**
	 * 添加GoodsConment所有数据
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public int insertGoodsComment() {
		return pubGoodsCommentDAO.insertGoodsComment(MMUtil.getMM());
	}

	/**
	 * 根据categoryId查询Goods所有数据
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findGoods() {
		MM mm = MMUtil.getMM();
		return pubGoodsDAO.findGoods(mm);
	}

	/**
	 * 根据id查询GoodsComment所有数据
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectGoodsCommentByGoodsId() {
		return pubGoodsCommentDAO.selectGoodsCommentByGoodsId(MMUtil.getMM());
	}

	/**
	 * 根据ID查询GoodsDetail所有数据
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findGoodsDetail() {
		MM mm = MMUtil.getMM();
		return pubGoodsDAO.findGoodsDetail(mm);
	}

	@Override
	public Map<String, Object> getGoodsDetailById() {
		MM mm = MMUtil.getMM();
		Map<String, Object> goodsDetail = pubGoodsDAO.getGoodsDetailById(mm);
		return goodsDetail;
	}

}
