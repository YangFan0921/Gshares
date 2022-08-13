package com.review.shares.portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.review.shares.portal.exception.ServiceException;
import com.review.shares.portal.mapper.ClassroomMapper;
import com.review.shares.portal.mapper.UserRoleMapper;
import com.review.shares.portal.model.Classroom;
import com.review.shares.portal.model.Role;
import com.review.shares.portal.model.User;
import com.review.shares.portal.mapper.UserMapper;
import com.review.shares.portal.model.UserRole;
import com.review.shares.portal.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.review.shares.portal.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private ClassroomMapper classroomMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void registerStudent(RegisterVo registerVo) {
        //1.验证邀请码是否正确
        QueryWrapper<Classroom> query = new QueryWrapper<>();
        query.eq("invite_code",registerVo.getInviteCode());
        Classroom classroom = classroomMapper.selectOne(query);
        if (classroom == null){
            throw new SecurityException("邀请码错误！");
        }
        //2.验证手机号是否注册过
        User user = userMapper.findUserByUsername(registerVo.getPhone());
        if (user != null){
            throw new SecurityException("手机号已经注册过！");
        }
        //3.用户输入的密码加密
        String bcrypt = encoder.encode(registerVo.getPassword());
        bcrypt = "{bcrypt}"+bcrypt;
        //4.构建User对象并赋值
        User u = new User();
        u.setUsername(registerVo.getPhone());
        u.setNickname(registerVo.getNickname());
        u.setPassword(bcrypt);
        u.setClassroomId(classroom.getId());
        u.setCreatetime(LocalDateTime.now());
        u.setEnabled(1);
        u.setLocked(0);
        u.setType(0);
        //5.User新增至数据库
        int num = userMapper.insert(u);
        if (num != 1){
            throw new SecurityException("数据库异常，注册失败！");
        }
        //6.构建用户与角色的关系对象，并新增至关系表中
        UserRole userRole = new UserRole();
        userRole.setUserId(u.getId());
        userRole.setRoleId(2);
        num = userRoleMapper.insert(userRole);
        if (num != 1){
            throw new ServiceException("数据库异常，注册失败！");
        }
    }
}