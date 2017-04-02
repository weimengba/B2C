package com.util;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * MM 线程本地变量Util类,该类所有定义的变量和方法都是静态（static）的
 * 存放在方法区中，作为公共的变量和方法在全局都可以调用，可以直接使用类名点。
 * 
 * @author Administrator
 * 
 */
public class MMUtil {
	/*
	 * ThreadLocal：该类提供了线程局部 (thread-local) 变量。 这些变量不同于它们的普通对应物， 因为访问某个变量（通过其
	 * get 或 set 方法）的每个线程都有自己的局部变量， 它独立于变量的初始化副本。ThreadLocal 实例通常是类中的 private
	 * static 字段， 它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。 每个线程都保持对其线程局部变量副本的隐式引用，
	 * 只要线程是活动的并且 ThreadLocal 实例是可访问的；
	 * 在线程消失之后，其线程局部实例的所有副本都会被垃圾回收（除非存在对这些副本的其他引用）。
	 */

	// 生成对每个线程唯一的局部标识符:threadLocal。
	private static ThreadLocal<MM> threadLocal = new ThreadLocal<MM>();

	/**
	 * 从线程本地变量中获取MM
	 * 
	 * @return
	 */
	public static MM getMM() {
		// threadLocal返回此线程局部变量的当前线程副本中的值。
		MM mm = threadLocal.get();
		if (mm == null) {
			mm = new MM();
			// 将此线程局部变量的当前线程副本中的值设置为指定值。
			threadLocal.set(mm);
		}
		// 返回mm对象
		return mm;
	}

	/**
	 * 释放线程局部变量资源
	 */
	public static void clear() {
		// threadLocal返回此线程局部变量的当前线程副本中的值。
		MM mm = threadLocal.get();
		if (mm != null) {
			// 调用MM类中clear()方法从该映射中移除所有映射关系。
			mm.clear();
			// 移除此线程局部变量当前线程的值。
			threadLocal.remove();
			// 将mm设置为null让垃圾回收器自动回收
			mm = null;
		}
	}

	/**
	 * 方便方法，获取对象，必须在过滤器执行后使用。
	 * 
	 * @return
	 */
	public static Object get(String key) {
		// 调用本类中getMM()方法，获取MM对象，并调用MM中get方法
		// 获取指定建的值
		return getMM().get(key);
	}

	/**
	 * 方便方法，设置对象，必须在过滤器执行后使用。
	 * 
	 * @return
	 */
	public static void put(String key, Object value) {
		getMM().put(key, value);
	}

	/**
	 * 方便方法，获取请求对象，必须在过滤器执行后使用。
	 * 
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return (HttpServletRequest) getMM().get("mm_reqeust");
	}

	/**
	 * 设置分页参数。
	 * 
	 * @return
	 */
	public static void setPageParam(String curString) {
		int cur = 1;
		if (null != curString && !"".equals(curString)) {
			try {
				cur = Integer.parseInt(curString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		getMM().put("mm_cur", cur);
		getMM().put("mm_app_pagesize", 10);
	}

	/**
	 * 设置排序参数。
	 * 
	 * @return
	 */
	public static void setOrder(String orderName, String desc) {
		if (null != orderName && !"".equals(orderName)) {

			ServletContext sc = (ServletContext) getMM().get("mm_context");
			WebApplicationContext springContext = WebApplicationContextUtils
					.getWebApplicationContext(sc);
			GlobalDataUtil globalDataUtil = (GlobalDataUtil) springContext
					.getBean("GlobalDataUtil");
			// getMM().put("c_od", globalDataUtil.getColumnMapName(orderName));
			getMM().put("commonOrder",
					globalDataUtil.getColumnMapName(orderName));
		}
		if (null != desc && !"".equals(desc)) {
			getMM().put("c_desc", desc);
			getMM().put("commonDesc", desc);
		}
	}

	/**
	 * 取得当前页。
	 * 
	 * @return
	 */
	public static Integer getCurrent() {
		Object cur = getMM().get("mm_cur");
		if (cur != null) {
			return (Integer) cur;
		} else {
			return 1;
		}
	}

	/**
	 * 取得每页条数。
	 * 
	 * @return
	 */
	public static Integer getPageSize() {
		Object pageSize = getMM().get("mm_session_pagesize");
		if (pageSize != null) {
			return (Integer) pageSize;
		} else {
			pageSize = getMM().get("mm_app_pagesize");
			if (pageSize != null) {
				return (Integer) pageSize;
			} else {
				return 10;
			}
		}
	}

	/**
	 * 输出MM调试信息。
	 */

	public static void printMMMessage() {
		SysUtil.debug("****************MM 调试信息开始*****************");
		MM mm = getMM();
		Set<String> keySet = mm.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Object value = mm.get(key);
			SysUtil.debug("\t" + key + ":" + value);
		}
		SysUtil.debug("****************MM 调试信息结束*****************");
	}
}
