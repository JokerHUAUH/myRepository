package day50Demo;

import redis.clients.jedis.Jedis;

public class Demo1 {

	public static void main(String[] args) {
		
//		NO1.����Jedis����
		Jedis jedis = new Jedis("127.0.0.1",6379);
		
//		NO2.ʹ��Jedis�����API����Redis���ݿ�,�����ѡ�����ݿ�,Ĭ��0�����ݿ�
		jedis.select(0);
		
		jedis.set("username","Jack");
		
		String one = jedis.get("username");
		
		System.out.println(one);
		
		jedis.close();
		
	}

}
