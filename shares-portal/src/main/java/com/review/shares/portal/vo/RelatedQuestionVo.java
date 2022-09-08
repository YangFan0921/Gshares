package com.review.shares.portal.vo;

import lombok.Data;


public class RelatedQuestionVo {
    //问题id
    private Integer id;
    //问题标题
    private String title;
    //问题状态
    private Integer status;
    //浏览量
    private Integer pageViews;
    //回答数
    private Integer countAnswer;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getTitle() {
        return this.title;
    }

    @SuppressWarnings("all")
    public Integer getStatus() {
        return this.status;
    }

    @SuppressWarnings("all")
    public Integer getPageViews() {
        return this.pageViews;
    }

    @SuppressWarnings("all")
    public Integer getCountAnswer() {
        return this.countAnswer;
    }

    @SuppressWarnings("all")
    public RelatedQuestionVo setId(final Integer id) {
        this.id = id;
        return this;
    }

    @SuppressWarnings("all")
    public RelatedQuestionVo setTitle(final String title) {
        this.title = title;
        return this;
    }

    @SuppressWarnings("all")
    public RelatedQuestionVo setStatus(final Integer status) {
        this.status = status;
        return this;
    }

    @SuppressWarnings("all")
    public RelatedQuestionVo setPageViews(final Integer pageViews) {
        this.pageViews = pageViews;
        return this;
    }

    @SuppressWarnings("all")
    public RelatedQuestionVo setCountAnswer(final Integer countAnswer) {
        this.countAnswer = countAnswer;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RelatedQuestionVo)) return false;
        final RelatedQuestionVo other = (RelatedQuestionVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$pageViews = this.getPageViews();
        final Object other$pageViews = other.getPageViews();
        if (this$pageViews == null ? other$pageViews != null : !this$pageViews.equals(other$pageViews)) return false;
        final Object this$countAnswer = this.getCountAnswer();
        final Object other$countAnswer = other.getCountAnswer();
        if (this$countAnswer == null ? other$countAnswer != null : !this$countAnswer.equals(other$countAnswer)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof RelatedQuestionVo;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $pageViews = this.getPageViews();
        result = result * PRIME + ($pageViews == null ? 43 : $pageViews.hashCode());
        final Object $countAnswer = this.getCountAnswer();
        result = result * PRIME + ($countAnswer == null ? 43 : $countAnswer.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "HotQuestionVo(id=" + this.getId() + ", title=" + this.getTitle() + ", status=" + this.getStatus() + ", pageViews=" + this.getPageViews() + ", countAnswer=" + this.getCountAnswer() + ")";
    }

    @SuppressWarnings("all")
    public RelatedQuestionVo(final Integer id, final String title, final Integer status, final Integer pageViews, final Integer countAnswer) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.pageViews = pageViews;
        this.countAnswer = countAnswer;
    }

    @SuppressWarnings("all")
    public RelatedQuestionVo() {
    }
    //</editor-fold>
}
