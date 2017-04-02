import java.util.Iterator;
import java.util.List;

import redis.clients.jedis.Jedis;

public class TestJRedis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost",6379);
		System.out.println("Connection to server sucessfully");
		// 查看服务是否运行
		System.out.println("Server is running: " + jedis.ping());

		jedis.set("kkkk1", "abc");

		String value = jedis.get("kkkk1");
		System.out.println(value);

		for (int i = 0; i < 100; i++) {
			jedis.lpush("loginuser", "" + i);
		}
		
		List<String> data = jedis.lrange("loginuser", 0, 100);
		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

	}

}
