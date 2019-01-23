package com.susoft.service.impl;

import com.susoft.entity.Role;
import com.susoft.mapper.RoleMapper;
import com.susoft.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Date;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
	@Override
	public boolean deleteById(Integer id,Integer updateUser){
		return updateById(new Role() {{setId(id);setDeleteFlag(1);}});
	}
}
