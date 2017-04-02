package com.pub.dao;

import java.util.List;
import java.util.Map;

public interface PubOrderViewDAO {
	List<Map<String,Object>>OrderView(Map<String, Object> param);
}
