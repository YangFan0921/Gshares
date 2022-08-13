package com.review.shares.portal.service;

import com.review.shares.portal.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.review.shares.portal.vo.RegisterVo;

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

}
