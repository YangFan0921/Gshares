package com.review.shares.portal.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//V(Value)o(object) vo:值对象
// 用于封装项目开发过程中一些数据
@Data
public class RegisterVo {
    //与前端页面中的name值一致
    @NotBlank(message = "邀请码不能为空")
    private String inviteCode;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1\\d{10}$",message = "手机号码格式不正确")
    private String phone;

    @NotBlank(message = "昵称不能为空")
    @Pattern(regexp = "^.{2,20}$",message = "昵称长度为2-20")
    private String nickname;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^\\w{6,20}$",message = "密码长度为6-20")
    private String password;

    @NotBlank(message = "确认密码不能为空")
    private String confirm;
}
