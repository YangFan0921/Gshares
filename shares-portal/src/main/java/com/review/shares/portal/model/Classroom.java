package com.review.shares.portal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("classroom")
public class Classroom implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 班级名称
     */
    @TableField("name")
    private String name;
    /**
     * 邀请码
     */
    @TableField("invite_code")
    private String inviteCode;
    /**
     * 班级是否可用
     */
    @TableField("enabled")
    private Integer enabled;
    @TableField("createtime")
    private LocalDateTime createtime;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Classroom() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    /**
     * 班级名称
     */
    @SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    /**
     * 邀请码
     */
    @SuppressWarnings("all")
    public String getInviteCode() {
        return this.inviteCode;
    }

    /**
     * 班级是否可用
     */
    @SuppressWarnings("all")
    public Integer getEnabled() {
        return this.enabled;
    }

    @SuppressWarnings("all")
    public LocalDateTime getCreatetime() {
        return this.createtime;
    }

    @SuppressWarnings("all")
    public Classroom setId(final Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 班级名称
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Classroom setName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * 邀请码
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Classroom setInviteCode(final String inviteCode) {
        this.inviteCode = inviteCode;
        return this;
    }

    /**
     * 班级是否可用
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Classroom setEnabled(final Integer enabled) {
        this.enabled = enabled;
        return this;
    }

    @SuppressWarnings("all")
    public Classroom setCreatetime(final LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Classroom(id=" + this.getId() + ", name=" + this.getName() + ", inviteCode=" + this.getInviteCode() + ", enabled=" + this.getEnabled() + ", createtime=" + this.getCreatetime() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Classroom)) return false;
        final Classroom other = (Classroom) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$enabled = this.getEnabled();
        final Object other$enabled = other.getEnabled();
        if (this$enabled == null ? other$enabled != null : !this$enabled.equals(other$enabled)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$inviteCode = this.getInviteCode();
        final Object other$inviteCode = other.getInviteCode();
        if (this$inviteCode == null ? other$inviteCode != null : !this$inviteCode.equals(other$inviteCode)) return false;
        final Object this$createtime = this.getCreatetime();
        final Object other$createtime = other.getCreatetime();
        if (this$createtime == null ? other$createtime != null : !this$createtime.equals(other$createtime)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Classroom;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $enabled = this.getEnabled();
        result = result * PRIME + ($enabled == null ? 43 : $enabled.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $inviteCode = this.getInviteCode();
        result = result * PRIME + ($inviteCode == null ? 43 : $inviteCode.hashCode());
        final Object $createtime = this.getCreatetime();
        result = result * PRIME + ($createtime == null ? 43 : $createtime.hashCode());
        return result;
    }
    //</editor-fold>
}
