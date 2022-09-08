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
@TableName("answer")
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 回答内容
     */
    @TableField("content")
    private String content;
    /**
     * 点赞数量
     */
    @TableField("like_count")
    private Integer likeCount;
    /**
     * 回答问题的用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 回答者用户名
     */
    @TableField("user_nick_name")
    private String userNickName;
    /**
     * 对应的问题id
     */
    @TableField("quest_id")
    private Integer questId;
    /**
     * 回答时间
     */
    @TableField("createtime")
    private LocalDateTime createtime;
    /**
     * 是否采纳
     */
    @TableField("accept_status")
    private Integer acceptStatus;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Answer() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    /**
     * 回答内容
     */
    @SuppressWarnings("all")
    public String getContent() {
        return this.content;
    }

    /**
     * 点赞数量
     */
    @SuppressWarnings("all")
    public Integer getLikeCount() {
        return this.likeCount;
    }

    /**
     * 回答问题的用户id
     */
    @SuppressWarnings("all")
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * 回答者用户名
     */
    @SuppressWarnings("all")
    public String getUserNickName() {
        return this.userNickName;
    }

    /**
     * 对应的问题id
     */
    @SuppressWarnings("all")
    public Integer getQuestId() {
        return this.questId;
    }

    /**
     * 回答时间
     */
    @SuppressWarnings("all")
    public LocalDateTime getCreatetime() {
        return this.createtime;
    }

    /**
     * 是否采纳
     */
    @SuppressWarnings("all")
    public Integer getAcceptStatus() {
        return this.acceptStatus;
    }

    @SuppressWarnings("all")
    public Answer setId(final Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 回答内容
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Answer setContent(final String content) {
        this.content = content;
        return this;
    }

    /**
     * 点赞数量
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Answer setLikeCount(final Integer likeCount) {
        this.likeCount = likeCount;
        return this;
    }

    /**
     * 回答问题的用户id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Answer setUserId(final Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 回答者用户名
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Answer setUserNickName(final String userNickName) {
        this.userNickName = userNickName;
        return this;
    }

    /**
     * 对应的问题id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Answer setQuestId(final Integer questId) {
        this.questId = questId;
        return this;
    }

    /**
     * 回答时间
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Answer setCreatetime(final LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }

    /**
     * 是否采纳
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Answer setAcceptStatus(final Integer acceptStatus) {
        this.acceptStatus = acceptStatus;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Answer(id=" + this.getId() + ", content=" + this.getContent() + ", likeCount=" + this.getLikeCount() + ", userId=" + this.getUserId() + ", userNickName=" + this.getUserNickName() + ", questId=" + this.getQuestId() + ", createtime=" + this.getCreatetime() + ", acceptStatus=" + this.getAcceptStatus() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Answer)) return false;
        final Answer other = (Answer) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$likeCount = this.getLikeCount();
        final Object other$likeCount = other.getLikeCount();
        if (this$likeCount == null ? other$likeCount != null : !this$likeCount.equals(other$likeCount)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$questId = this.getQuestId();
        final Object other$questId = other.getQuestId();
        if (this$questId == null ? other$questId != null : !this$questId.equals(other$questId)) return false;
        final Object this$acceptStatus = this.getAcceptStatus();
        final Object other$acceptStatus = other.getAcceptStatus();
        if (this$acceptStatus == null ? other$acceptStatus != null : !this$acceptStatus.equals(other$acceptStatus)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$userNickName = this.getUserNickName();
        final Object other$userNickName = other.getUserNickName();
        if (this$userNickName == null ? other$userNickName != null : !this$userNickName.equals(other$userNickName)) return false;
        final Object this$createtime = this.getCreatetime();
        final Object other$createtime = other.getCreatetime();
        if (this$createtime == null ? other$createtime != null : !this$createtime.equals(other$createtime)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Answer;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $likeCount = this.getLikeCount();
        result = result * PRIME + ($likeCount == null ? 43 : $likeCount.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $questId = this.getQuestId();
        result = result * PRIME + ($questId == null ? 43 : $questId.hashCode());
        final Object $acceptStatus = this.getAcceptStatus();
        result = result * PRIME + ($acceptStatus == null ? 43 : $acceptStatus.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $userNickName = this.getUserNickName();
        result = result * PRIME + ($userNickName == null ? 43 : $userNickName.hashCode());
        final Object $createtime = this.getCreatetime();
        result = result * PRIME + ($createtime == null ? 43 : $createtime.hashCode());
        return result;
    }
    //</editor-fold>
}
