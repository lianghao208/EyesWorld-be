package org.tvos.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import org.tvos.entity.Province;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Redis缓存Dao
 */
public class RedisDao {

    private final JedisPool jedisPool;

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    private static RuntimeSchema<CacheEntry> schema = RuntimeSchema.createFrom(CacheEntry.class);


    public List<Province> getProvinceListForSpots(){
        try {
            //redis读缓存操作
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "province";
                //自定义序列化protostuff
                byte[] bytes = jedis.get(key.getBytes());
                //
                if (bytes != null) {
                    CacheEntry cacheEntry = schema.newMessage();//获取空对象
                    ProtostuffIOUtil.mergeFrom(bytes, cacheEntry, schema);//photoDto被赋值
                    return cacheEntry.getProvinceList();//反序列化
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
             System.out.println("无法连接Redis服务器");
        }

        return null;
    }

    public String putProvinceListForSpots(List<Province> provinceList) {

        try {
            //redis写缓存操作：将photoDto对象序列化成字节数组
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "province";
                CacheEntry cacheEntry = new CacheEntry(provinceList);
                byte[] bytes = ProtostuffIOUtil.toByteArray(cacheEntry,
                        schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                System.out.println(bytes.length);
                //超时缓存 1 小时
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            System.out.println("无法连接Redis服务器");
        }

        return null;
    }

}
class CacheEntry{
    private List<Province> provinceList;
    public CacheEntry(List<Province> provinceList){
        this.provinceList=provinceList;
    }
    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }
}
