package com.cd.coordination.global;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class RedisPool {
    private static JedisPool pool;//jedis连接池
    private static Integer maxTotal = Integer.parseInt("20"); //最大连接数
    private static Integer maxIdle = Integer.parseInt("20");//在jedispool中最大的idle状态(空闲的)的jedis实例的个数
    private static Integer minIdle = Integer.parseInt("20");//在jedispool中最小的idle状态(空闲的)的jedis实例的个数

    private static Boolean testOnBorrow = Boolean.parseBoolean("true");//在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true。则得到的jedis实例肯定是可以用的。
    private static Boolean testOnReturn = Boolean.parseBoolean("true");//在return一个jedis实例的时候，是否要进行验证操作，如果赋值true。则放回jedispool的jedis实例肯定是可以用的。

    private static String redisIp = "127.0.0.1";
    private static Integer redisPort = 21;


    private static void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);

        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);

        config.setBlockWhenExhausted(true);//连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时。默认为true。

        pool = new JedisPool(config, redisIp, redisPort, 1000 * 2);
    }

    static {
        initPool();
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }


    public static void returnBrokenResource(Jedis jedis) {
        pool.returnBrokenResource(jedis);
    }


    public static void returnResource(Jedis jedis) {
        pool.returnResource(jedis);
    }


//    @Test
//   public void test(){
//        JedisPool redisPool=new JedisPool();
//        redisPool.getResource();
//        System.out.println("123");
//    }


}
