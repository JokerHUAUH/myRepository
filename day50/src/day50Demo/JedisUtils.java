package day50Demo;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		NO.1)创建Jedis对象连接池对象,类似c3p0-config.xml文件
		JedisPoolConfig config = new JedisPoolConfig();
		
//		NO.2)设置Jedis连接池中最多有多少个对象
		config.setMaxTotal(10);
		
//		NO.3)设置Jedis连接池中最长等待时间
		config.setMaxWaitMillis(3000);

		JedisPool pool = new JedisPool(config,"127.0.0.1",6379);
		
		Jedis jedis = pool.getResource();
		
		jedis.lpush("teacher",new String[]{"飞哥","醒哥","波哥","君哥"});
		
		List<String> list = jedis.lrange("teacher",0,-1);
		
		for (String string : list) {
			System.out.print(string+"	");
		}
		
		jedis.close();
		
	}

}
