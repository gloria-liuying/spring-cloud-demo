package com.susoft.cache;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/22
 */
@Component
public final class RedisUtil {
    private final static Logger logger = LogManager.getLogger(RedisUtil.class);
    //token过期时间3h
    private final static long TOKEN_EXPIRE_TIME = 60*60*3L;
    //验证码过期时间5min
    private final static long CODE_EXPIRE_TIME = 60*5L;
    //token的前缀
    private final static String TOKEN_PREFIX = "token_";
    //验证码前缀
    private final static String CODE_PREFIX ="code_";
    //过期或者黑名单验证码
    private final static String TOKEN_BLACK_LIST = "token_black_list";
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 删除token
     */
    @SuppressWarnings("unchecked")
    public boolean removeToken(String... keys){
        boolean flag = false;
        if(keys.length==1){
            flag = redisTemplate.delete(keys[0]);
        }else{
            flag = redisTemplate.delete(CollectionUtils.arrayToList(keys))==keys.length;
        }
        return flag;
    }
    public Object getToken(String token){
        return get(TOKEN_PREFIX+token);
    }
    /**
     * 添加token
     */
    public boolean setToken(String token,Object object){
        return set(TOKEN_PREFIX+token,object,TOKEN_EXPIRE_TIME);
    }
    /**
     * 添加验证码
     */
    public Boolean setCode(String key,String code){
        return set(CODE_PREFIX+key,code,CODE_EXPIRE_TIME);
    }
    /**
     * 删除token
     */
    public boolean delToken(String token){
        return removeToken(TOKEN_PREFIX+token);
    }
    /**
     * 添加键值对
     */
    public boolean set(String key,Object object,long times){
        boolean flag = false;
        try{
            redisTemplate.opsForValue().set(key,object,times, TimeUnit.SECONDS);
            flag = true;
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return flag;
    }
    /**
     * 获取键值对
     */
    public Object get(String key){
        try{
            return redisTemplate.opsForValue().get(key);
        }catch(Exception e){
            logger.error(e.getMessage());
        }return null;
    }
    /**
     * 验证验证码
     */
    public boolean checkCode(String phoneNumber,String code){
        boolean flag = false;
        try{
            Object object = get(CODE_PREFIX+phoneNumber);
            if(object!=null&&code.equals(object)){
                flag = true;
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return flag;
    }
    /**
     * 判断是否存在某个key
     */
    public boolean exist(String key){
        boolean flag = false;
        try{
            flag = redisTemplate.hasKey(key);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return flag;
    }
    /**
     * 添加token到黑名单
     */
    public boolean addTokenBlackList(String token){
        boolean flag = false;
        try{
            Long add = redisTemplate.opsForSet().add(TOKEN_BLACK_LIST,token);
            if(add>0){
                flag = true;
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return flag;
    }
    /**
     * 判断是否在黑名单中
     * @param token
     * @return
     */
    public boolean checkTokenBlackList(String token) {
        boolean flag = false;
        try {
            flag = redisTemplate.opsForSet().isMember(TOKEN_BLACK_LIST, token);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return flag;
    }
}
