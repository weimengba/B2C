package com.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pub.service.WeixinServiceI;

/**
 * 微信过滤器
 * 
 * @author sqy
 * 
 */
public class WeixinFilter implements Filter {
	static String weixin = "MicroMessenger";

	@Override
	public void doFilter(ServletRequest r, ServletResponse s, FilterChain fc)
			throws IOException, ServletException {
		// 获得HttpServlet请求，
		HttpServletRequest request = (HttpServletRequest) r;
		HttpServletResponse response = (HttpServletResponse) s;

		// 获得用户请求的session
		HttpSession session = request.getSession();

		// Enumeration<String> headers = request.getHeaderNames();
		// while (headers.hasMoreElements()) {
		// String header = headers.nextElement();
		// System.out.println(header + ":" + request.getHeader(header));
		// }
		String userAgent = request.getHeader("user-agent");
		if (userAgent.indexOf(weixin) != -1) {
			// 微信的请求

			// 1、检查Session中是否存有OpenId。有，则正常的流程。没有，需要微信 oauth2登录。
			String openid = (String) session.getAttribute("openid");
			if (openid != null) {
				fc.doFilter(r, s);
			} else {
				// 2、检查请求参数：code，有则继续，没有则。重定向到：https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
				String code = request.getParameter("code");
				System.out.println("***********code:" + code
						+ "***************");
				if (code == null) {
					response.sendRedirect(WeiXinUtil.getOauth2Code(request
							.getRequestURL().toString()));
				} else {
					// 3、通过code换取网页授权access_token
					Map accessToken = WeiXinUtil.getAccessTokenByCode(code);
					// 4、拉取用户信息(需scope为 snsapi_userinfo)。进行自动用户的注册，登录的逻辑。
					Map userInfo = WeiXinUtil
							.getUserInfoByAccessToken(accessToken);
					System.out.println("*******************微信UserInfo："
							+ userInfo + "*****************");
					// 微信获取信息后，根据openid，判断用户是否在本系统中存在。不存在，则创建用户。
					WebApplicationContext springContext = WebApplicationContextUtils
							.getWebApplicationContext(session
									.getServletContext());
					WeixinServiceI weixinService = (WeixinServiceI) springContext
							.getBean("weixinService");

					//不管用户是否登陆过系统，都会返回用户信息。(微信用户是自动登录的情况。)
					Map user = weixinService.weixinLogin(userInfo);
					// 会话中存储用户信息。
					if(user != null){
						session.setAttribute("openid", userInfo.get("openid"));
						session.setAttribute("c_cid", userInfo.get(user.get("id")));
					}
					fc.doFilter(r, s);
				}
			}
		} else {
			// 非微信的请求
			fc.doFilter(r, s);
		}
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {

	}

	@Override
	public void destroy() {

	}
}
