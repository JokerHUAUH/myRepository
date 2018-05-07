package day50Demo;

import java.util.List;

import redis.clients.jedis.Jedis;

public class Demo2 {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis();
		
		jedis.hset("PERSON","USERNAME","ут╬Щ");
		jedis.hset("PERSON","PASSWORD","123456");
		jedis.hsetnx("PERSON","SALARY","5000");
		
		List<String> list = jedis.hmget("PERSON",new String[]{"USERNAME","PASSWORD","SALARY"});
		
		for (String string : list) {
			System.out.println(string);
		}
		
		jedis.close();
		
	}

}
