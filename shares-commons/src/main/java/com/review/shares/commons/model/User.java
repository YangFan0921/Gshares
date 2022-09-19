package com.review.shares.commons.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField("username")
    private String username;
    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 性别
     */
    @TableField("sex")
    private String sex;
    /**
     * 生日
     */
    @TableField("birthday")
    private LocalDate birthday;
    /**
     * 电话号码
     */
    @TableField("phone")
    private String phone;
    /**
     * 所属班级id
     */
    @TableField("classroom_id")
    private Integer classroomId;
    /**
     * 注册时间
     */
    @TableField("createtime")
    private LocalDateTime createtime;
    /**
     * 账号是否可用，0-》否，1-》是
     */
    @TableField("enabled")
    private Integer enabled;
    /**
     * 账号是否被锁住，0-》否，1-》是
     */
    @TableField("locked")
    private Integer locked;
    /**
     * 0-》学生，1-》回答问题的老师
     */
    @TableField("type")
    private Integer type;
    /**
     * 自我介绍
     */
    @TableField("self_introduction")
    private String selfIntroduction;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public User() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    /**
     * 用户名
     */
    @SuppressWarnings("all")
    public String getUsername() {
        return this.username;
    }

    /**
     * 昵称
     */
    @SuppressWarnings("all")
    public String getNickname() {
        return this.nickname;
    }

    /**
     * 密码
     */
    @SuppressWarnings("all")
    public String getPassword() {
        return this.password;
    }

    /**
     * 性别
     */
    @SuppressWarnings("all")
    public String getSex() {
        return this.sex;
    }

    /**
     * 生日
     */
    @SuppressWarnings("all")
    public LocalDate getBirthday() {
        return this.birthday;
    }

    /**
     * 电话号码
     */
    @SuppressWarnings("all")
    public String getPhone() {
        return this.phone;
    }

    /**
     * 所属班级id
     */
    @SuppressWarnings("all")
    public Integer getClassroomId() {
        return this.classroomId;
    }

    /**
     * 注册时间
     */
    @SuppressWarnings("all")
    public LocalDateTime getCreatetime() {
        return this.createtime;
    }

    /**
     * 账号是否可用，0-》否，1-》是
     */
    @SuppressWarnings("all")
    public Integer getEnabled() {
        return this.enabled;
    }

    /**
     * 账号是否被锁住，0-》否，1-》是
     */
    @SuppressWarnings("all")
    public Integer getLocked() {
        return this.locked;
    }

    /**
     * 0-》学生，1-》回答问题的老师
     */
    @SuppressWarnings("all")
    public Integer getType() {
        return this.type;
    }

    /**
     * 自我介绍
     */
    @SuppressWarnings("all")
    public String getSelfIntroduction() {
        return this.selfIntroduction;
    }

    @SuppressWarnings("all")
    public User setId(final Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 用户名
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setUsername(final String username) {
        this.username = username;
        return this;
    }

    /**
     * 昵称
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setNickname(final String nickname) {
        this.nickname = nickname;
        return this;
    }

    /**
     * 密码
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setPassword(final String password) {
        this.password = password;
        return this;
    }

    /**
     * 性别
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setSex(final String sex) {
        this.sex = sex;
        return this;
    }

    /**
     * 生日
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setBirthday(final LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * 电话号码
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setPhone(final String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * 所属班级id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setClassroomId(final Integer classroomId) {
        this.classroomId = classroomId;
        return this;
    }

    /**
     * 注册时间
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setCreatetime(final LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }

    /**
     * 账号是否可用，0-》否，1-》是
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setEnabled(final Integer enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * 账号是否被锁住，0-》否，1-》是
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setLocked(final Integer locked) {
        this.locked = locked;
        return this;
    }

    /**
     * 0-》学生，1-》回答问题的老师
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setType(final Integer type) {
        this.type = type;
        return this;
    }

    /**
     * 自我介绍
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public User setSelfIntroduction(final String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "User(id=" + this.getId() + ", username=" + this.getUsername() + ", nickname=" + this.getNickname() + ", password=" + this.getPassword() + ", sex=" + this.getSex() + ", birthday=" + this.getBirthday() + ", phone=" + this.getPhone() + ", classroomId=" + this.getClassroomId() + ", createtime=" + this.getCreatetime() + ", enabled=" + this.getEnabled() + ", locked=" + this.getLocked() + ", type=" + this.getType() + ", selfIntroduction=" + this.getSelfIntroduction() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$classroomId = this.getClassroomId();
        final Object other$classroomId = other.getClassroomId();
        if (this$classroomId == null ? other$classroomId != null : !this$classroomId.equals(other$classroomId)) return false;
        final Object this$enabled = this.getEnabled();
        final Object other$enabled = other.getEnabled();
        if (this$enabled == null ? other$enabled != null : !this$enabled.equals(other$enabled)) return false;
        final Object this$locked = this.getLocked();
        final Object other$locked = other.getLocked();
        if (this$locked == null ? other$locked != null : !this$locked.equals(other$locked)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$sex = this.getSex();
        final Object other$sex = other.getSex();
        if (this$sex == null ? other$sex != null : !this$sex.equals(other$sex)) return false;
        final Object this$birthday = this.getBirthday();
        final Object other$birthday = other.getBirthday();
        if (this$birthday == null ? other$birthday != null : !this$birthday.equals(other$birthday)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$createtime = this.getCreatetime();
        final Object other$createtime = other.getCreatetime();
        if (this$createtime == null ? other$createtime != null : !this$createtime.equals(other$createtime)) return false;
        final Object this$selfIntroduction = this.getSelfIntroduction();
        final Object other$selfIntroduction = other.getSelfIntroduction();
        if (this$selfIntroduction == null ? other$selfIntroduction != null : !this$selfIntroduction.equals(other$selfIntroduction)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $classroomId = this.getClassroomId();
        result = result * PRIME + ($classroomId == null ? 43 : $classroomId.hashCode());
        final Object $enabled = this.getEnabled();
        result = result * PRIME + ($enabled == null ? 43 : $enabled.hashCode());
        final Object $locked = this.getLocked();
        result = result * PRIME + ($locked == null ? 43 : $locked.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $sex = this.getSex();
        result = result * PRIME + ($sex == null ? 43 : $sex.hashCode());
        final Object $birthday = this.getBirthday();
        result = result * PRIME + ($birthday == null ? 43 : $birthday.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $createtime = this.getCreatetime();
        result = result * PRIME + ($createtime == null ? 43 : $createtime.hashCode());
        final Object $selfIntroduction = this.getSelfIntroduction();
        result = result * PRIME + ($selfIntroduction == null ? 43 : $selfIntroduction.hashCode());
        return result;
    }
    //</editor-fold>
}
