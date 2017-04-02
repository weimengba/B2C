package com.util;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.platform.service.CommonServiceI;

/**
 * 通用的监听器类.
 * 
 * @author Administrator
 * 
 */
public class CommonListener implements ServletContextListener {
	/*
	 * 在 Servlet API 中有一个 ServletContextListener 接口， 它能够监听 ServletContext
	 * 对象的生命周期，实际上就是监听 Web 应用的生命周期。 当Servlet 容器启动或终止Web
	 * 应用时，会触发ServletContextEvent 事件， 该事件由ServletContextListener 来处理。 在
	 * ServletContextListener 接口中定义了处理ServletContextEvent 事件的两个方法。
	 */
	/*
	 * ServletContext,是一个全局的储存信息的空间，服务器开始，其就存在，
	 * 服务器关闭，其才释放。request，一个用户可有多个；session，一个用户一个；
	 * 而servletContext，所有用户共用一个。所以，为了节省空间，提高效率，
	 * ServletContext中，要放必须的、重要的、所有用户需要共享的线程又是安全的一些信息。
	 * ServletContext接口定义了运行servlet的web应用的servlet视图。
	 * 容器供应商负责提供servlet容器内ServletContext接口的实现。
	 * 使用ServletContext对象，servlet可以记录事件日志，获取资源的URL地址，
	 * 并且设置和保存上下文内可以访问的其他servlet的属性。
	 */

	/**
	 * 当应用开始的时候它会调用此方法;上下文中初始化系统所有表的Map对象
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		// 调试模式打开
		sc.setAttribute("sys_debug", true);

		WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext(sc);
		// 获取平台菜单数据
		CommonServiceI commonService = (CommonServiceI) springContext
				.getBean("commonService");
		List menus = commonService.commonFindAll("sysMenu");
		sc.setAttribute("sys_menu", menus);

		//系统数据字典
		sc.setAttribute("sys_dict", SysUtil.getSysDict());
		//系统配置文件
		sc.setAttribute("sys_config", SysUtil.getSysConfig());
		//系统配置文件
		sc.setAttribute("sys_image_prefix", "image.jsp?path=");
	}

	/**
	 * 当应用关闭的时候,它同样会调用此方法.上下文中移除系统所有表的Map对象
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.removeAttribute("sys_debug");
		sc.removeAttribute("sys_menu");
	}

}
