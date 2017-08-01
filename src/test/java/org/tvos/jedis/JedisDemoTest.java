package org.tvos.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/30.
 */
public class JedisDemoTest {
    @Test
    public void testPoll() throws Exception {
        //获得连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(30);
        //设置最大空闲连接数
        config.setMaxIdle(10);
        //获得连接池
        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);
        //获得核心对象
        Jedis jedis = null;
        try {
            //通过连接池获得连接
            jedis = jedisPool.getResource();
            //设置数据
            jedis.set("name","张三");
            //获取数据
            String value = jedis.get("name");
            System.out.println(value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            if(jedis!=null){
                jedis.close();
            }
            if(jedisPool!=null){
                jedisPool.close();
            }

        }



    }

    @Test
    public void testJedis() throws Exception {
        //设置IP地址和端口
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //保存数据
        jedis.set("name","lianghao");
        //获取数据e
        String value = jedis.get("name");
        System.out.println(value);
        //释放数据
        jedis.close();
    }

}