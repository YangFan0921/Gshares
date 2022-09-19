package com.review.shares.commons.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
//链式函数的支持
/**
 * <p>
 * 
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@TableName("tag")
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("createby")
    private String createby;
    @TableField("createtime")
    private LocalDateTime createtime;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Tag() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    public String getCreateby() {
        return this.createby;
    }

    @SuppressWarnings("all")
    public LocalDateTime getCreatetime() {
        return this.createtime;
    }

    @SuppressWarnings("all")
    public Tag setId(final Integer id) {
        this.id = id;
        return this;
    }

    @SuppressWarnings("all")
    public Tag setName(final String name) {
        this.name = name;
        return this;
    }

    @SuppressWarnings("all")
    public Tag setCreateby(final String createby) {
        this.createby = createby;
        return this;
    }

    @SuppressWarnings("all")
    public Tag setCreatetime(final LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Tag(id=" + this.getId() + ", name=" + this.getName() + ", createby=" + this.getCreateby() + ", createtime=" + this.getCreatetime() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Tag)) return false;
        final Tag other = (Tag) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$createby = this.getCreateby();
        final Object other$createby = other.getCreateby();
        if (this$createby == null ? other$createby != null : !this$createby.equals(other$createby)) return false;
        final Object this$createtime = this.getCreatetime();
        final Object other$createtime = other.getCreatetime();
        if (this$createtime == null ? other$createtime != null : !this$createtime.equals(other$createtime)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Tag;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $createby = this.getCreateby();
        result = result * PRIME + ($createby == null ? 43 : $createby.hashCode());
        final Object $createtime = this.getCreatetime();
        result = result * PRIME + ($createtime == null ? 43 : $createtime.hashCode());
        return result;
    }
    //</editor-fold>
}
