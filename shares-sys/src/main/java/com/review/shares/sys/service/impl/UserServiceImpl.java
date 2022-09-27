package com.review.shares.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.review.shares.commons.exception.ServiceException;
import com.review.shares.commons.model.*;
import com.review.shares.sys.mapper.ClassroomMapper;
import com.review.shares.sys.mapper.UserMapper;
import com.review.shares.sys.mapper.UserRoleMapper;
import com.review.shares.sys.service.IUserService;
import com.review.shares.sys.vo.RegisterVo;
import com.review.shares.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

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
//    private List<User> teachers = new CopyOnWriteArrayList<>();

    private Map<String,User> teacherMap = new ConcurrentHashMap<>();
    private Timer timer = new Timer();

    /*{
        //30分钟清空一次缓存 和数据库进行数据的同步
        //初始化代码块在构造方法前运行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                synchronized (teachers){
                    synchronized (teacherMap){
                        teachers.clear();
                        teacherMap.clear();
                    }
                }
                System.out.println("缓存已清空");
            }
        },1000*60*30,1000*60*30);
    }*/

    @Override
    @Transactional
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

    @Resource
    private RedisTemplate<String,List<User>> redisTemplate;
    @Override
    public List<User> getTeachers() {
        /*if (teachers.isEmpty()){
            synchronized (teachers){
                if (teachers.isEmpty()){
                    QueryWrapper<User> query = new QueryWrapper<>();
                    query.eq("type",1);
                    teachers = userMapper.selectList(query);
                    for (User user : teachers){
                        teacherMap.put(user.getNickname(),user);
                    }
                }
            }
        }*/
        List<User> teachers = redisTemplate.opsForValue().get("teachers");
        if(teachers==null || teachers.isEmpty()){
            QueryWrapper<User> query = new QueryWrapper<>();
            query.eq("type",1);
            teachers = userMapper.selectList(query);
            redisTemplate.opsForValue().set("teachers",teachers);
            System.out.println(redisTemplate.opsForValue().get("teachers"));
            System.out.println("老师缓存已加载！");
        }
        return teachers;
    }

    @Override
    public Map<String, User> getTeacherMap() {
        if (teacherMap.isEmpty()){
            getTeachers();
        }
        return teacherMap;
    }


    @Override
    public UserVo getCurrentUserVo(String username) {
        UserVo userVo = userMapper.findUserVoByUsername(username);
        return userVo;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }

    @Override
    public List<Role> getRolesById(Integer id) {
        return userMapper.findUserRolesById(id);
    }

    @Override
    public List<Permission> getPermissionsById(Integer id) {
        return userMapper.findUserPermissionsByID(id);
    }


}
