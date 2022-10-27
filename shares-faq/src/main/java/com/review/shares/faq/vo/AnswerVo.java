package com.review.shares.faq.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AnswerVo implements Serializable {
    @NotNull(message = "问题id不能为空")
    private Integer questionId;
    @NotBlank(message = "回答内容不能为空")
    private String content;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public AnswerVo() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getQuestionId() {
        return this.questionId;
    }

    @SuppressWarnings("all")
    public String getContent() {
        return this.content;
    }

    @SuppressWarnings("all")
    public AnswerVo setQuestionId(final Integer questionId) {
        this.questionId = questionId;
        return this;
    }

    @SuppressWarnings("all")
    public AnswerVo setContent(final String content) {
        this.content = content;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AnswerVo)) return false;
        final AnswerVo other = (AnswerVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$questionId = this.getQuestionId();
        final Object other$questionId = other.getQuestionId();
        if (this$questionId == null ? other$questionId != null : !this$questionId.equals(other$questionId)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof AnswerVo;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $questionId = this.getQuestionId();
        result = result * PRIME + ($questionId == null ? 43 : $questionId.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "AnswerVo(questionId=" + this.getQuestionId() + ", content=" + this.getContent() + ")";
    }
    //</editor-fold>
}
