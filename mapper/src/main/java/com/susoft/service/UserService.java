package com.susoft.service;

import com.susoft.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author forrest
 * @since 2019-01-18
 */
public interface UserService extends IService<User> {
			boolean deleteById(Integer id,Integer updateUser);
            public User findUserByUsername(String username);
            public List<String> findUserRoles(Integer userId);
}
