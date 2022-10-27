package com.review.shares.faq.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class QuestionVo implements Serializable {
    @NotBlank(message = "标题不能为空")
    @Pattern(regexp = "^.{3,50}$", message = "标题长度要求3~50")
    private String title;
    @NotEmpty(message = "至少选择一个标签")
    private String[] tagNames = {};
    @NotEmpty(message = "至少选择一位老师")
    private String[] teacherNicknames = {};
    @NotBlank(message = "问题内容不能为空")
    private String content;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public QuestionVo() {
    }

    @SuppressWarnings("all")
    public String getTitle() {
        return this.title;
    }

    @SuppressWarnings("all")
    public String[] getTagNames() {
        return this.tagNames;
    }

    @SuppressWarnings("all")
    public String[] getTeacherNicknames() {
        return this.teacherNicknames;
    }

    @SuppressWarnings("all")
    public String getContent() {
        return this.content;
    }

    @SuppressWarnings("all")
    public QuestionVo setTitle(final String title) {
        this.title = title;
        return this;
    }

    @SuppressWarnings("all")
    public QuestionVo setTagNames(final String[] tagNames) {
        this.tagNames = tagNames;
        return this;
    }

    @SuppressWarnings("all")
    public QuestionVo setTeacherNicknames(final String[] teacherNicknames) {
        this.teacherNicknames = teacherNicknames;
        return this;
    }

    @SuppressWarnings("all")
    public QuestionVo setContent(final String content) {
        this.content = content;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuestionVo)) return false;
        final QuestionVo other = (QuestionVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        if (!java.util.Arrays.deepEquals(this.getTagNames(), other.getTagNames())) return false;
        if (!java.util.Arrays.deepEquals(this.getTeacherNicknames(), other.getTeacherNicknames())) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof QuestionVo;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        result = result * PRIME + java.util.Arrays.deepHashCode(this.getTagNames());
        result = result * PRIME + java.util.Arrays.deepHashCode(this.getTeacherNicknames());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "QuestionVo(title=" + this.getTitle() + ", tagNames=" + java.util.Arrays.deepToString(this.getTagNames()) + ", teacherNicknames=" + java.util.Arrays.deepToString(this.getTeacherNicknames()) + ", content=" + this.getContent() + ")";
    }
    //</editor-fold>
}
