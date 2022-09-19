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
@TableName("user_question")
public class UserQuestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;
    @TableField("question_id")
    private Integer questionId;
    @TableField("createtime")
    private LocalDateTime createtime;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public UserQuestion() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public Integer getUserId() {
        return this.userId;
    }

    @SuppressWarnings("all")
    public Integer getQuestionId() {
        return this.questionId;
    }

    @SuppressWarnings("all")
    public LocalDateTime getCreatetime() {
        return this.createtime;
    }

    @SuppressWarnings("all")
    public UserQuestion setId(final Integer id) {
        this.id = id;
        return this;
    }

    @SuppressWarnings("all")
    public UserQuestion setUserId(final Integer userId) {
        this.userId = userId;
        return this;
    }

    @SuppressWarnings("all")
    public UserQuestion setQuestionId(final Integer questionId) {
        this.questionId = questionId;
        return this;
    }

    @SuppressWarnings("all")
    public UserQuestion setCreatetime(final LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "UserQuestion(id=" + this.getId() + ", userId=" + this.getUserId() + ", questionId=" + this.getQuestionId() + ", createtime=" + this.getCreatetime() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserQuestion)) return false;
        final UserQuestion other = (UserQuestion) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$questionId = this.getQuestionId();
        final Object other$questionId = other.getQuestionId();
        if (this$questionId == null ? other$questionId != null : !this$questionId.equals(other$questionId)) return false;
        final Object this$createtime = this.getCreatetime();
        final Object other$createtime = other.getCreatetime();
        if (this$createtime == null ? other$createtime != null : !this$createtime.equals(other$createtime)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof UserQuestion;
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
        final Object $questionId = this.getQuestionId();
        result = result * PRIME + ($questionId == null ? 43 : $questionId.hashCode());
        final Object $createtime = this.getCreatetime();
        result = result * PRIME + ($createtime == null ? 43 : $createtime.hashCode());
        return result;
    }
    //</editor-fold>
}
