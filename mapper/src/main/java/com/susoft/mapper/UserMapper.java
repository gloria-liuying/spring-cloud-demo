package com.susoft.mapper;

import com.susoft.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author forrest
 * @since 2019-01-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select r.role_key from t_role r where r.id in\n" +
            "(select r.id from t_user_role tur where tur.user_id = #{userId}) ")
    List<String> findUserRolesById(@Param("userId") Integer userId);
}
