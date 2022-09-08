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
@TableName("comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 回答id
     */
    @TableField("answer_id")
    private Integer answerId;
    /**
     * 评论内容
     */
    @TableField("content")
    private String content;
    /**
     * 创建时间
     */
    @TableField("createtime")
    private LocalDateTime createtime;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Comment() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    /**
     * 主键
     */
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
     * 回答id
     */
    @SuppressWarnings("all")
    public Integer getAnswerId() {
        return this.answerId;
    }

    /**
     * 评论内容
     */
    @SuppressWarnings("all")
    public String getContent() {
        return this.content;
    }

    /**
     * 创建时间
     */
    @SuppressWarnings("all")
    public LocalDateTime getCreatetime() {
        return this.createtime;
    }

    /**
     * 主键
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Comment setId(final Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 用户id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Comment setUserId(final Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 回答id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Comment setAnswerId(final Integer answerId) {
        this.answerId = answerId;
        return this;
    }

    /**
     * 评论内容
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Comment setContent(final String content) {
        this.content = content;
        return this;
    }

    /**
     * 创建时间
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Comment setCreatetime(final LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Comment(id=" + this.getId() + ", userId=" + this.getUserId() + ", answerId=" + this.getAnswerId() + ", content=" + this.getContent() + ", createtime=" + this.getCreatetime() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Comment)) return false;
        final Comment other = (Comment) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$answerId = this.getAnswerId();
        final Object other$answerId = other.getAnswerId();
        if (this$answerId == null ? other$answerId != null : !this$answerId.equals(other$answerId)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$createtime = this.getCreatetime();
        final Object other$createtime = other.getCreatetime();
        if (this$createtime == null ? other$createtime != null : !this$createtime.equals(other$createtime)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Comment;
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
        final Object $answerId = this.getAnswerId();
        result = result * PRIME + ($answerId == null ? 43 : $answerId.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $createtime = this.getCreatetime();
        result = result * PRIME + ($createtime == null ? 43 : $createtime.hashCode());
        return result;
    }
    //</editor-fold>
}
