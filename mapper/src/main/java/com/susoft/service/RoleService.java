package com.susoft.service;

import com.susoft.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author forrest
 * @since 2019-01-18
 */
public interface RoleService extends IService<Role> {
			boolean deleteById(Integer id,Integer updateUser);
}
