package com.myit.intf.service.cache;


public interface RedisService {

    /**
     * 
     * 功能描述: <br>
     * 获取redis缓存对象
     * 
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String get(String key);

    /**
     * 
     * 功能描述: <br>
     * 添加redis缓存
     * 
     * @param key
     * @param value
     * @param timeout
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void set(String key, String value, int timeout);

    /**
     * 
     * 功能描述: <br>
     * 删除redis缓存
     * 
     * @param key
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void delete(String key);
}
