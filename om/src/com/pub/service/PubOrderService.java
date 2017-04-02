package com.pub.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.pub.controller.BasePubController;
import com.pub.dao.PubCustomerCartDAO;
import com.pub.dao.PubOrderDAO;
import com.util.MM;
import com.util.MMUtil;

/**
 * 平台 订单实现类
 * 
 * @author 郭兰鑫
 * 
 */

@Service
public class PubOrderService extends BasePubService implements PubOrderServiceI {
	@Resource
	PubOrderDAO pubOrderDao;
    /**
     * 添加订单
     */
	@SuppressWarnings("unchecked")
	@Override
	public int insertOrder() {
		return pubOrderDao.insertOrder(MMUtil.getMM());
	}
    /**
     * 根据Id修改订单
     */
	@SuppressWarnings("unchecked")
	@Override
	public int updateOrderByid() {
		return pubOrderDao.updateOrderByid(MMUtil.getMM());
	}
    /**
     * 订单查询
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectOrder() {
		List<Map<String, Object>> data=pubOrderDao.selectOrder(MMUtil.getMM());
		return data;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>>selectOrderBycustomerId(){
		List<Map<String, Object>> data=pubOrderDao.selectOrderBycustomerId(MMUtil.getMM());
		return data;
		
	}
	
	@Transactional
	public boolean placeOrder() throws ServletException, IOException{  //修改成List<map>返回类型
		//所购买的物品ID
		/**
		 * 1.根据购物车提交的商品信息 （商品ID，商品数量，订单总价，）去数据库核查 ，如果库存足够
		 * 添加相应订单信息，订单详细，订单历史。如果库存不足就跳转到订单修改页面（修改库存，或者删除此类商品）
		 * 
		 * 
		 */
		/* String customer_id=  "2" ;(int);
		 System.out.println(customer_id);*/
		//json形式购物信息（商品ID  数量   单价）
		List data = JSON.parseArray(MMUtil.getMM().get("data").toString());
		//如果c_mmid中有值就用c_mmid，如果没有就用用户ID2
		 if(MMUtil.getMM().get("c_mmid")!=null){
			 MMUtil.getMM().put("customerId", MMUtil.getMM().get("c_mmid"));
		 } else{
			 MMUtil.getMM().put("customerId", "2");
		 }
		 System.out.println(MMUtil.getMM().get("customerId"));
	     //添加一个新的订单
	     HashMap<String, Object> order=new HashMap<String, Object>();	
	     order.put("customer_id", "2");
	     order.put("state", "0");
	     order.put("total_price", "0");
	     order.put("pay", "0");
	     order.put("customer_address_id", "1");
	     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	     order.put("ctime",df.format(new Date()));
	     order.put("is_del","0");
	     //把前台计算好的商品总价放入MM中
		 MMUtil.getMM().put("totalPrice", MMUtil.getMM().get("sumprice"));
	     System.out.println("---------添加一个新的订单");
	     pubOrderDAO.insertOrder(order);
	     System.out.println(order.get("id")+"<--新生成的ID号"); 
	     Map<String, Object> kcbu=new HashMap<>();//如果有商品库存不足会存入这个map
	     MMUtil.getMM().put("OutItem", kcbu);
	     for (int i = 0; i < data.size(); i++) {
				Map map = (Map)data.get(i);
	    	    //获取购买数量
	    		Object num=map.get("num");	
	    		//获取购买商品ID
	    		Object goodsId=map.get("goods_id");
	    		//把商品ID放到MM中进行条件查询
	    		MMUtil.getMM().put("id", goodsId.toString());
	    		//通过id查询库存
	    		Map<String, Object> maps=findGoodsDynamic();
	    		  System.out.println("库存+"+maps.get("num"));  
	    		  System.out.println("购买数量+"+map.get("num"));
	    		int kc= Integer.parseInt(maps.get("num").toString()); //获取库存    		
	    		int paynum= Integer.parseInt(num.toString());//购买数量
    		if(kc>paynum||kc==paynum){
    				//从商品库存中减去购买数量，占住购买商品个数
   				 Map<String, Object> mm = MMUtil.getMM();
   				 mm.put("id", map.get("goods_id"));
   				 int res=kc-paynum; 				
   				 String shengyu = Integer.toString(res);
   				 mm.put("num", shengyu);//修改库存
   				 pubGoodsDAO.updateGoodsById(mm);
   				 MMUtil.getMM().put("is_del","1");
   				 MMUtil.getMM().put("goodsId",map.get("goods_id"));
   				 //把购物车里的商品删除掉
   				 int c= pubCustomerCartDAO.updateCustomerCartById(MMUtil.getMM()); 
   				//----------添加订单物品详细----------
   				HashMap<String, Object> orderitem=new HashMap<String, Object>();
   				orderitem.put("order_id", order.get("id"));
   				orderitem.put("goods_id", map.get("goods_id"));
   				orderitem.put("goods_num", map.get("num"));
   				orderitem.put("goods_price", maps.get("price"));
   				orderitem.put("ctime", df.format(new Date()));
   				orderitem.put("is_del", "0");
   				int tt= pubOrderItemDAO.insertOrderItem(orderitem);
   				 if(tt>0){
   					 System.out.println("订单详细添加成功");  
   				 }
    			}else{
    				MMUtil.getMM().put("id", goodsId.toString());
    	    		//通过id查询库存
    				Map<String, Object> goods=findGoodsDynamic();
    	    		kcbu.put("goodsId", goods.get("id"));
    	    		kcbu.put("num", goods.get("num"));
    				System.out.println("库存不足， 订单详细添加失败");
    				System.out.println("有"+kcbu.size()+"样商品库存不足");
    				
    			}	 				
	    	}
	     
	     
	     
	     
	     
	     
	     
	     
	  
		return true;	
	}
	@SuppressWarnings({ "unchecked"})
	@Override
	@Test
	public List<Map<String, Object>> selectCustomerCart() {
		// TODO Auto-generated method stub
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("customerId", "2");
	     System.out.println(MMUtil.get("customerId"));
		return pubCustomerCartDAO.selectCustomerCart(MMUtil.getMM());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findGoodsDynamic() {
		return pubOrderDAO.findGoodsDynamic(MMUtil.getMM());
	}
	@SuppressWarnings("unchecked")
	@Override
	public int insertCustomerCart() {
		List<Map<String, Object>> data= pubCustomerCartDAO.selectCustomerCart(MMUtil.getMM());
		if(data!=null&&data.size()>0){
			int num=0;
			  for(int i = 0; i < data.size(); i++) {
		    		Object aa = data.get(i).get("num");
		    		num=num+Integer.parseInt(aa.toString());
		    	}
			 num=num+1;	//添加后数量		
			MMUtil.getMM().put("num",Integer.toString(num));
			return pubCustomerCartDAO.updateCustomerCartById(MMUtil.getMM());
		}else{
			return pubCustomerCartDAO.insertCustomerCart(MMUtil.getMM());	
		}
		
	}

}
