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
@TableName("question_tag")
public class QuestionTag implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("question_id")
    private Integer questionId;
    @TableField("tag_id")
    private Integer tagId;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public QuestionTag() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public Integer getQuestionId() {
        return this.questionId;
    }

    @SuppressWarnings("all")
    public Integer getTagId() {
        return this.tagId;
    }

    @SuppressWarnings("all")
    public QuestionTag setId(final Integer id) {
        this.id = id;
        return this;
    }

    @SuppressWarnings("all")
    public QuestionTag setQuestionId(final Integer questionId) {
        this.questionId = questionId;
        return this;
    }

    @SuppressWarnings("all")
    public QuestionTag setTagId(final Integer tagId) {
        this.tagId = tagId;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "QuestionTag(id=" + this.getId() + ", questionId=" + this.getQuestionId() + ", tagId=" + this.getTagId() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuestionTag)) return false;
        final QuestionTag other = (QuestionTag) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$questionId = this.getQuestionId();
        final Object other$questionId = other.getQuestionId();
        if (this$questionId == null ? other$questionId != null : !this$questionId.equals(other$questionId)) return false;
        final Object this$tagId = this.getTagId();
        final Object other$tagId = other.getTagId();
        if (this$tagId == null ? other$tagId != null : !this$tagId.equals(other$tagId)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof QuestionTag;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $questionId = this.getQuestionId();
        result = result * PRIME + ($questionId == null ? 43 : $questionId.hashCode());
        final Object $tagId = this.getTagId();
        result = result * PRIME + ($tagId == null ? 43 : $tagId.hashCode());
        return result;
    }
    //</editor-fold>
}
