package com.susoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.susoft.entity.User;
import com.susoft.mapper.UserMapper;
import com.susoft.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author forrest
 * @since 2019-01-18
 */
@Service
@CacheConfig(cacheNames = { "user" })
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Cacheable(key = "targetClass + methodName +#p0")
	@Override
	public User findUserByUsername(String username) {
		LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>().lambda().eq(User::getUserName, username);
		return userMapper.selectOne(wrapper);
	}

	@Override
	public boolean deleteById(Integer id,Integer updateUser){
		return updateById(new User() {{setId(id);setDeleteFlag(1);}});
	}

	@Cacheable(key = "targetClass + methodName +#p0")
	@Override
	public List<String> findUserRoles(Integer userId) {
		return userMapper.findUserRolesById(userId);
	}
}
