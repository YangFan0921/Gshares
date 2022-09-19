package com.review.shares.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.review.shares.commons.model.User;
import com.review.shares.sys.vo.RegisterVo;
import com.review.shares.sys.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
public interface IUserService extends IService<User> {

    // 注册学生
    void registerStudent(RegisterVo registerVo);

    //所有老师List
    List<User> getTeachers();

    //所有老师Map
    Map<String,User> getTeacherMap();

    //查询用户信息面板数据
    UserVo getCurrentUserVo(String username);



}
