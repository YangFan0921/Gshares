package com.review.shares.portal.mapper;

import com.review.shares.portal.model.Permission;
import com.review.shares.portal.model.Role;
import com.review.shares.portal.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.review.shares.portal.vo.UserVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

        //根据用户名查询用户信息
        @Select("select id,username,nickname,password,sex,birthday,phone,classroom_id,createtime,enabled,locked,type,self_introduction from user where username=#{username}")
        User findUserByUsername(String username);

        //根据用户id查询此用户的所有权限
        @Select("SELECT p.id, p.name" +
                " FROM user u" +
                " LEFT JOIN user_role ur ON u.id = ur.user_id" +
                " LEFT JOIN role r ON r.id = ur.role_id" +
                " LEFT JOIN role_permission rp ON r.id = rp.role_id" +
                " LEFT JOIN permission p ON p.id = rp.permission_id" +
                " WHERE" +
                " u.id =#{id}")
        List<Permission> findUserPermissionsByID(Integer id);

        //根据用户名查询UserVo信息
        @Select("select id,username,nickname from user where username=#{username}")
        UserVo findUserVoByUsername(String username);

        //根据用户id查询此用户所有的角色
        @Select("select r.id,r.name from user u " +
                "left join user_role ur on u.id = ur.user_id " +
                "left join role r on ur.role_id = r.id " +
                "where u.id = #{id}")
        List<Role> findUserRolesById(Integer id);


}
