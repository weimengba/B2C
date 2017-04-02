package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.util.MM;
import com.util.MMUtil;

/**
 * 管理后台商品service类。
 * 
 * @author Administrator
 * 
 */
@Service
public class PlatGoodsSevice extends BasePlatService implements PlatGoodsSeviceI{

	@Override
	public List<Map<String, Object>> selectGoods() {
		MM mm = MMUtil.getMM();
		List<Map<String, Object>> data = platGoodsDAO.selectGoods(mm);
		return data;
		
	}
/**
 * 修改
 */
	@Override
	public void updateGoodsById() {
		MM mm = MMUtil.getMM();
		platGoodsDAO.updateGoodsById(mm);
	}

	/**
	 * 添加
	 */
	@Override
	public void insertGoods() {
		MM mm = MMUtil.getMM();
		platGoodsDAO.insertGoods(mm);
	}
	@Override
	public Object selectGoodsPhoto() {
		MM mm = MMUtil.getMM();
		Object ObjectId = mm.get("id");
		mm.put("objectId", ObjectId);
		mm.put("type", "goodsPhoto");
		
		Object list = platGoodsDAO.selectGoodsPhoto(mm);
		return list;
	}
	
	@Override
	public Object selectGoodsImg() {
		MM mm = MMUtil.getMM();
		Object ObjectId = mm.get("id");
		mm.put("objectId", ObjectId);
		mm.put("type", "goodsImg");
		
		Object list = platGoodsDAO.selectGoodsPhoto(mm);
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void goodsDeletePhoto(String type, int id) {
		MM mm = MMUtil.getMM();
		mm.put("id", id);
		mm.put("type", type);
		platGoodsDAO.goodsDeletePhoto(mm);
	}
	@Override
	public List<Map<String, Object>> selectGoodsById(int id) {
		MM mm = MMUtil.getMM();
		mm.put("id", id);
		List object = platGoodsDAO.selectGoodsById(mm);
		return object;
	}
	
}
