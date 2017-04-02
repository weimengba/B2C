package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.util.MMUtil;

/**
 * 平台管理 业务报表Service
 * 
 * @author 苏鹏
 */

@Service
public class PlatReportService extends BasePlatService implements PlatReportServiceI {

	@Override
	public List<Map<String, Object>> selectOrderStatistics() {
		// TODO 还没实现
		return null;
	}

	@Override
	public List<Map<String, Object>> selectSaleDetails() {
		// TODO 还没实现
		return null;
	}

	@Override
	public List<Map<String, Object>> selectSalesRank() {
		
		return platReportDAO.selectSalesRank(MMUtil.getMM());
	}
}
