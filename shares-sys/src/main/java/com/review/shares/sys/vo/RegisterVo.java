package com.review.shares.sys.vo;

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
    @Pattern(regexp = "^1\\d{10}$", message = "手机号码格式不正确")
    private String phone;
    @NotBlank(message = "昵称不能为空")
    @Pattern(regexp = "^.{2,20}$", message = "昵称长度为2-20")
    private String nickname;
    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^\\w{6,20}$", message = "密码长度为6-20")
    private String password;
    @NotBlank(message = "确认密码不能为空")
    private String confirm;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public RegisterVo() {
    }

    @SuppressWarnings("all")
    public String getInviteCode() {
        return this.inviteCode;
    }

    @SuppressWarnings("all")
    public String getPhone() {
        return this.phone;
    }

    @SuppressWarnings("all")
    public String getNickname() {
        return this.nickname;
    }

    @SuppressWarnings("all")
    public String getPassword() {
        return this.password;
    }

    @SuppressWarnings("all")
    public String getConfirm() {
        return this.confirm;
    }

    @SuppressWarnings("all")
    public void setInviteCode(final String inviteCode) {
        this.inviteCode = inviteCode;
    }

    @SuppressWarnings("all")
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @SuppressWarnings("all")
    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    @SuppressWarnings("all")
    public void setPassword(final String password) {
        this.password = password;
    }

    @SuppressWarnings("all")
    public void setConfirm(final String confirm) {
        this.confirm = confirm;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RegisterVo)) return false;
        final RegisterVo other = (RegisterVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$inviteCode = this.getInviteCode();
        final Object other$inviteCode = other.getInviteCode();
        if (this$inviteCode == null ? other$inviteCode != null : !this$inviteCode.equals(other$inviteCode)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$confirm = this.getConfirm();
        final Object other$confirm = other.getConfirm();
        if (this$confirm == null ? other$confirm != null : !this$confirm.equals(other$confirm)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof RegisterVo;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $inviteCode = this.getInviteCode();
        result = result * PRIME + ($inviteCode == null ? 43 : $inviteCode.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $confirm = this.getConfirm();
        result = result * PRIME + ($confirm == null ? 43 : $confirm.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "RegisterVo(inviteCode=" + this.getInviteCode() + ", phone=" + this.getPhone() + ", nickname=" + this.getNickname() + ", password=" + this.getPassword() + ", confirm=" + this.getConfirm() + ")";
    }
    //</editor-fold>
}
