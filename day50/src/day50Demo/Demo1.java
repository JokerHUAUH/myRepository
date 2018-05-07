package day50Demo;

import redis.clients.jedis.Jedis;

public class Demo1 {

	public static void main(String[] args) {
		
//		NO1.创建Jedis对象
		Jedis jedis = new Jedis("127.0.0.1",6379);
		
//		NO2.使用Jedis对象的API操作Redis数据库,如果不选择数据库,默认0号数据库
		jedis.select(0);
		
		jedis.set("username","Jack");
		
		String one = jedis.get("username");
		
		System.out.println(one);
		
		jedis.close();
		
	}

}
