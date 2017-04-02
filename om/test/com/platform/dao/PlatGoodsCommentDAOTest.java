package com.platform.dao;

 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.util.MM;
import com.util.MMUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
/**
 * 管理后台GoodsTypeDAO类测试

 *
 */
public class PlatGoodsCommentDAOTest {

	@Resource
	PlatGoodsCommentDAO platGoodsCommentDAO;

    /**
     * 查询所有的商品评论
     */
	@Test
	public void selectGoodsComment() {
		MM mm = MMUtil.getMM();
		mm.put("star", 3);
	List<Map<String,Object>> hh = platGoodsCommentDAO.selectGoodsComment(mm);
		for (Map<String, Object> s : hh) {
			System.out.println(s);
		}
		Assert.assertNotNull(hh);
	}
	
	/**
     * 添加一个商品评论
     */     
	@Test
	public void insertGoodsComment(){
		Map<String, Object> param =new HashMap<String,Object>();
		param.put("orderItemId", 3);
		param.put("customerId", 3);
		param.put("goodsId", 3);
		param.put("star", 3);
		param.put("content", 3);
		param.put("state", 3);
	
		param.put("isDel", 1);
	
		int i = platGoodsCommentDAO.insertGoodsComment(param);	 
		Assert.assertEquals(1,i);
   }
    /*  	
     * 修改商品评论
     
	@Test
	public void updateGoodsById() {
		
		 
		 Map<String, Object> param =new HashMap<String,Object>();
		 param.put("id", 1);
		 
		 param.put("categoryId", 5);
		 param.put("typeId", 5);
		 param.put("title", "桃红葡萄酒");
		 param.put("price", 200.00);
		 param.put("marketPrice", 1000.00);
		 param.put("quantity", 10);
		 param.put("num", 23);
		 param.put("brief", "桃红葡萄酒，口感好");
		 param.put("detail", "桃红葡萄酒，价格实惠");
		 param.put("isDel", 0);
		 platGoodsDAO.updateGoodsById(param);
			
	}*/
	
}
