package org.tvos.jedis;

import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/7/30.
 */
public class JedisDemo {


    public void testJedis(){
        //设置IP地址和端口
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //保存数据
        jedis.set("name","lianghao");
        //获取数据
        String value = jedis.get("name");
        System.out.println(value);
        //释放数据
        jedis.close();
    }

    /**
     * 连接池方式连接
     */
    public void testPoll(){

    }

}
