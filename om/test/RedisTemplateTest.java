import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pub.dao.RedisDAO;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
public class RedisTemplateTest {

	@Resource
	StringRedisTemplate redisTemplate;

	@Resource
	RedisDAO redisDAO;

	/**
	 * 测试添加登录方式
	 */
	@Test
	public void testInsertCustomerSns() {
		//
		BoundListOperations<String, String> list = redisTemplate
				.boundListOps("loginuser");
		List<String> data = list.range(0, 100);
		// for (Iterator iterator = data.iterator(); iterator.hasNext();) {
		// String string = (String) iterator.next();
		// System.out.println(string);
		// }

		BoundValueOperations string = redisTemplate.boundValueOps("string1");

		System.out.println(string.get());
		string.set(new Date().toString());

		BoundHashOperations hash = redisTemplate.boundHashOps("hash1");

		Object name = hash.get("age");

		System.out.println(name);

		Assert.assertNotNull("");
	}

	@Test
	public void testRedisDAO() {
		List loginuser = redisDAO.getLoginUser();
		for (Iterator iterator = loginuser.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		Assert.assertNotNull("");
	}
	
	@Test
	public void testgetLoginUser() {
		Map user = redisDAO.getLoginUser("loginuser:abc");
		System.out.println(user);
		Assert.assertNotNull(user);
	}
	

	@Test
	public void testsetLoginUser() {
		Map user = new HashMap();
		user.put("id", "99");
		user.put("name", "小明");
		redisDAO.setLoginUser("loginuser:zz",user);
		System.out.println(user);
		Assert.assertNotNull(user);
	}
}
