
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.platform.dao.PlatCommonFileDAO;
import com.util.GlobalDataUtil;
import com.util.MM;
import com.util.MMUtil;

//配置使用Spring的单元测试启动类
@RunWith(SpringJUnit4ClassRunner.class)
// 配置使用的Spring配置文件
@ContextConfiguration(locations = { "classpath*:/conf/spring-model.xml" })
/**
 * 公共文件DAO测试类
 * @author lml
 * 
 */
public class GlobalDataUtilTest {
	@Resource
	GlobalDataUtil globalDataUtil;

	/**
	 * 测试
	 */
	@Test
	public void testInsertFile() {
		globalDataUtil.init();

		Assert.assertEquals(1, 1);
	}

}
