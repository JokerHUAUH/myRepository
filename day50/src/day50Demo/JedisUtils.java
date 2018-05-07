package day50Demo;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		NO.1)����Jedis�������ӳض���,����c3p0-config.xml�ļ�
		JedisPoolConfig config = new JedisPoolConfig();
		
//		NO.2)����Jedis���ӳ�������ж��ٸ�����
		config.setMaxTotal(10);
		
//		NO.3)����Jedis���ӳ�����ȴ�ʱ��
		config.setMaxWaitMillis(3000);

		JedisPool pool = new JedisPool(config,"127.0.0.1",6379);
		
		Jedis jedis = pool.getResource();
		
		jedis.lpush("teacher",new String[]{"�ɸ�","�Ѹ�","����","����"});
		
		List<String> list = jedis.lrange("teacher",0,-1);
		
		for (String string : list) {
			System.out.print(string+"	");
		}
		
		jedis.close();
		
	}

}
