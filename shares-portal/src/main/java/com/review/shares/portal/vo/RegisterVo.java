package com.review.shares.portal.vo;

import lombok.Data;

//V(Value)o(object) vo:值对象
// 用于封装项目开发过程中一些数据
@Data
public class RegisterVo {
    //与前端页面中的name值一致
    private String inviteCode;
    private String phone;
    private String nickname;
    private String password;
    private String confirm;
}
