package com.review.shares.commons.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@TableName("user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public UserRole() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    /**
     * 用户id
     */
    @SuppressWarnings("all")
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * 角色id
     */
    @SuppressWarnings("all")
    public Integer getRoleId() {
        return this.roleId;
    }

    @SuppressWarnings("all")
    public UserRole setId(final Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 用户id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public UserRole setUserId(final Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 角色id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public UserRole setRoleId(final Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "UserRole(id=" + this.getId() + ", userId=" + this.getUserId() + ", roleId=" + this.getRoleId() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserRole)) return false;
        final UserRole other = (UserRole) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$roleId = this.getRoleId();
        final Object other$roleId = other.getRoleId();
        if (this$roleId == null ? other$roleId != null : !this$roleId.equals(other$roleId)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof UserRole;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $roleId = this.getRoleId();
        result = result * PRIME + ($roleId == null ? 43 : $roleId.hashCode());
        return result;
    }
    //</editor-fold>
}
