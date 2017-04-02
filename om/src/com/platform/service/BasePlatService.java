package com.platform.service;

import javax.annotation.Resource;

import com.platform.dao.CommonDAO;
import com.platform.dao.PlatCommonFileDAO;
import com.platform.dao.PlatCommonLogDAO;
import com.platform.dao.PlatCustomerAddressDAO;
import com.platform.dao.PlatCustomerCartDAO;
import com.platform.dao.PlatCustomerDAO;
import com.platform.dao.PlatCustomerSnsDAO;
import com.platform.dao.PlatGoodsAttrDAO;
import com.platform.dao.PlatGoodsAttrValueDAO;
import com.platform.dao.PlatGoodsCategoryDAO;
import com.platform.dao.PlatGoodsCommentDAO;
import com.platform.dao.PlatGoodsDAO;
import com.platform.dao.PlatGoodsTypeDAO;
import com.platform.dao.PlatOrderDAO;
import com.platform.dao.PlatOrderHistoryDAO;
import com.platform.dao.PlatOrderItemDAO;
import com.platform.dao.PlatOrderPaymentDAO;
import com.platform.dao.PlatReportDAO;
import com.platform.dao.PlatSysManagerDAO;
import com.platform.dao.PlatSysManagerRoleDAO;
import com.platform.dao.PlatSysPermissionDAO;
import com.platform.dao.PlatSysRoleDAO;
import com.platform.dao.PlatSysRolePermissionDAO;
import com.pub.dao.DemoDAO;
import com.util.GlobalDataUtil;

public class BasePlatService {

	@Resource
	GlobalDataUtil globalDataUtil;

	@Resource
	DemoDAO demoDAO;

	@Resource
	CommonDAO commonDAO;

	@Resource
	PlatCommonFileDAO platCommonFileDAO;

	@Resource
	PlatCommonLogDAO platCommonLogDAO;

	@Resource
	PlatCustomerAddressDAO platCustomerAddressDAO;

	@Resource
	PlatCustomerCartDAO platCustomerCartDAO;

	@Resource
	PlatCustomerDAO platCustomerDAO;

	@Resource
	PlatCustomerSnsDAO platCustomerSnsDAO;

	@Resource
	PlatGoodsAttrDAO platGoodsAttrDAO;

	@Resource
	PlatGoodsAttrValueDAO platGoodsAttrValueDAO;

	@Resource
	PlatGoodsCategoryDAO platGoodsCategoryDAO;

	@Resource
	PlatGoodsCommentDAO platGoodsCommentDAO;

	@Resource
	PlatGoodsDAO platGoodsDAO;

	@Resource
	PlatGoodsTypeDAO platGoodsTypeDAO;

	@Resource
	PlatOrderDAO platOrderDAO;

	@Resource
	PlatOrderHistoryDAO platOrderHistoryDAO;

	@Resource
	PlatOrderItemDAO platOrderItemDAO;

	@Resource
	PlatOrderPaymentDAO platOrderPaymentDAO;

	@Resource
	PlatSysManagerDAO platSysManagerDAO;

	@Resource
	PlatSysManagerRoleDAO platSysManagerRoleDAO;

	@Resource
	PlatSysPermissionDAO platSysPermissionDAO;

	@Resource
	PlatSysRoleDAO platSysRoleDAO;

	@Resource
	PlatSysRolePermissionDAO platSysRolePermissionDAO;
	
	@Resource
	PlatReportDAO platReportDAO;
}
