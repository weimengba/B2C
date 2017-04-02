package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.util.MMUtil;

/**
 * 管理后台商品类别service类。
 * 
 * @author Administrator
 * 
 */

@Service
public class PlatGoodsTypeSevice extends BasePlatService implements PlatGoodsTypeSeviceI{

	@Override
	public List<Map<String, Object>> selectGoodsType() {
		List<Map<String, Object>> data = platGoodsTypeDAO.selectGoodsType(MMUtil.getMM());
		return data;
	}

	@Override
	public int insertGoodsType() {
		return platGoodsTypeDAO.insertGoodsType(MMUtil.getMM());
	}

	@Override
	public int updateGoodsTypeById() {
		return platGoodsTypeDAO.updateGoodsTypeById(MMUtil.getMM());
	}
	
	
	
}
