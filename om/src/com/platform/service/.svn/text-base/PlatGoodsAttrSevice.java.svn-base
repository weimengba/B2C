package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.platform.dao.PlatGoodsAttrDAO;
import com.util.MM;
import com.util.MMUtil;


/**
 * 管理后台商品属性service类。
 * 
 * @author Administrator
 * 
 */
@Service
public class PlatGoodsAttrSevice extends BasePlatService implements PlatGoodsAttrSeviceI{

	@Override
	public List<Map<String, Object>> selectGoodsAttr() {
		MM mm = MMUtil.getMM();
		List<Map<String, Object>> attr = platGoodsAttrDAO.selectGoodsAttr(mm);
		return attr;
	}

	@Override
	public void insertAttr() {
		MM mm = MMUtil.getMM();
		platGoodsAttrDAO.insertAttr(mm);
	}

	@Override
	public void updateAttrById() {
		platGoodsAttrDAO.updateAttrById(MMUtil.getMM());
	}

	@Override
	public List<Map<String, Object>> selectGoodsAttrByTypeId(Object typeId) {

		MM mm = MMUtil.getMM();
		mm.put("typeId", typeId);
		List<Map<String,Object>> list = platGoodsAttrDAO.selectGoodsAttrByTypeId(mm);
		return list;
	}
	
	
	
}
