package com.review.shares.commons.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@TableName("notice")
public class Notice implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 消息类型，0-》评论问题的回答，1-》回答某人的提问，2-》评论某人的提问
     */
    @TableField("type")
    private Integer type;
    /**
     * 问题id
     */
    @TableField("question_id")
    private Integer questionId;
    /**
     * 创建时间
     */
    @TableField("createtime")
    private LocalDateTime createtime;
    /**
     * 收到消息的用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 回复者id
     */
    @TableField("reply_user_id")
    private Integer replyUserId;
    /**
     * 消息是否已查看，0-》否，1-》是
     */
    @TableField("read_status")
    private Integer readStatus;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Notice() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    /**
     * 消息类型，0-》评论问题的回答，1-》回答某人的提问，2-》评论某人的提问
     */
    @SuppressWarnings("all")
    public Integer getType() {
        return this.type;
    }

    /**
     * 问题id
     */
    @SuppressWarnings("all")
    public Integer getQuestionId() {
        return this.questionId;
    }

    /**
     * 创建时间
     */
    @SuppressWarnings("all")
    public LocalDateTime getCreatetime() {
        return this.createtime;
    }

    /**
     * 收到消息的用户id
     */
    @SuppressWarnings("all")
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * 回复者id
     */
    @SuppressWarnings("all")
    public Integer getReplyUserId() {
        return this.replyUserId;
    }

    /**
     * 消息是否已查看，0-》否，1-》是
     */
    @SuppressWarnings("all")
    public Integer getReadStatus() {
        return this.readStatus;
    }

    @SuppressWarnings("all")
    public Notice setId(final Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 消息类型，0-》评论问题的回答，1-》回答某人的提问，2-》评论某人的提问
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Notice setType(final Integer type) {
        this.type = type;
        return this;
    }

    /**
     * 问题id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Notice setQuestionId(final Integer questionId) {
        this.questionId = questionId;
        return this;
    }

    /**
     * 创建时间
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Notice setCreatetime(final LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }

    /**
     * 收到消息的用户id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Notice setUserId(final Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 回复者id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Notice setReplyUserId(final Integer replyUserId) {
        this.replyUserId = replyUserId;
        return this;
    }

    /**
     * 消息是否已查看，0-》否，1-》是
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Notice setReadStatus(final Integer readStatus) {
        this.readStatus = readStatus;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Notice(id=" + this.getId() + ", type=" + this.getType() + ", questionId=" + this.getQuestionId() + ", createtime=" + this.getCreatetime() + ", userId=" + this.getUserId() + ", replyUserId=" + this.getReplyUserId() + ", readStatus=" + this.getReadStatus() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Notice)) return false;
        final Notice other = (Notice) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$questionId = this.getQuestionId();
        final Object other$questionId = other.getQuestionId();
        if (this$questionId == null ? other$questionId != null : !this$questionId.equals(other$questionId)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$replyUserId = this.getReplyUserId();
        final Object other$replyUserId = other.getReplyUserId();
        if (this$replyUserId == null ? other$replyUserId != null : !this$replyUserId.equals(other$replyUserId)) return false;
        final Object this$readStatus = this.getReadStatus();
        final Object other$readStatus = other.getReadStatus();
        if (this$readStatus == null ? other$readStatus != null : !this$readStatus.equals(other$readStatus)) return false;
        final Object this$createtime = this.getCreatetime();
        final Object other$createtime = other.getCreatetime();
        if (this$createtime == null ? other$createtime != null : !this$createtime.equals(other$createtime)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Notice;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $questionId = this.getQuestionId();
        result = result * PRIME + ($questionId == null ? 43 : $questionId.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $replyUserId = this.getReplyUserId();
        result = result * PRIME + ($replyUserId == null ? 43 : $replyUserId.hashCode());
        final Object $readStatus = this.getReadStatus();
        result = result * PRIME + ($readStatus == null ? 43 : $readStatus.hashCode());
        final Object $createtime = this.getCreatetime();
        result = result * PRIME + ($createtime == null ? 43 : $createtime.hashCode());
        return result;
    }
    //</editor-fold>
}
