package com.review.shares.portal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@TableName("role_permission")
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("role_id")
    private Integer roleId;
    @TableField("permission_id")
    private Integer permissionId;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public RolePermission() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public Integer getRoleId() {
        return this.roleId;
    }

    @SuppressWarnings("all")
    public Integer getPermissionId() {
        return this.permissionId;
    }

    @SuppressWarnings("all")
    public RolePermission setId(final Integer id) {
        this.id = id;
        return this;
    }

    @SuppressWarnings("all")
    public RolePermission setRoleId(final Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    @SuppressWarnings("all")
    public RolePermission setPermissionId(final Integer permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "RolePermission(id=" + this.getId() + ", roleId=" + this.getRoleId() + ", permissionId=" + this.getPermissionId() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RolePermission)) return false;
        final RolePermission other = (RolePermission) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$roleId = this.getRoleId();
        final Object other$roleId = other.getRoleId();
        if (this$roleId == null ? other$roleId != null : !this$roleId.equals(other$roleId)) return false;
        final Object this$permissionId = this.getPermissionId();
        final Object other$permissionId = other.getPermissionId();
        if (this$permissionId == null ? other$permissionId != null : !this$permissionId.equals(other$permissionId)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof RolePermission;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $roleId = this.getRoleId();
        result = result * PRIME + ($roleId == null ? 43 : $roleId.hashCode());
        final Object $permissionId = this.getPermissionId();
        result = result * PRIME + ($permissionId == null ? 43 : $permissionId.hashCode());
        return result;
    }
    //</editor-fold>
}
