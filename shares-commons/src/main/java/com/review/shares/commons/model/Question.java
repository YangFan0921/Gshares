package com.review.shares.commons.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@TableName("question")
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final Integer POSTED = 0; //已提交（未回复）
    public static final Integer SOLVING = 1; //未采纳（已回复）
    public static final Integer SOLVED = 2; //已采纳（已解决）

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 问题的标题
     */
    @TableField("title")
    private String title;
    /**
     * 提问内容
     */
    @TableField("content")
    private String content;
    /**
     * 提问者用户名
     */
    @TableField("user_nick_name")
    private String userNickName;
    /**
     * 提问者id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 创建时间
     */
    @TableField("createtime")
    private LocalDateTime createtime;
    /**
     * 状态，0-》未回答，1-》待解决，2-》已解决
     */
    @TableField("status")
    private Integer status;
    /**
     * 浏览量
     */
    @TableField("page_views")
    private Integer pageViews;
    /**
     * 该问题是否公开，所有学生都可见，0-》否，1-》是
     */
    @TableField("public_status")
    private Integer publicStatus;
    @TableField("modifytime")
    private LocalDate modifytime;
    @TableField("delete_status")
    private Integer deleteStatus;
    @TableField("tag_names")
    private String tagNames;
    /**
     * 当前问题的所有标签集合
     * 数据库表中无与之对应的列
     */
    @TableField(exist = false)
    private List<Tag> tags;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Question() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    /**
     * 问题的标题
     */
    @SuppressWarnings("all")
    public String getTitle() {
        return this.title;
    }

    /**
     * 提问内容
     */
    @SuppressWarnings("all")
    public String getContent() {
        return this.content;
    }

    /**
     * 提问者用户名
     */
    @SuppressWarnings("all")
    public String getUserNickName() {
        return this.userNickName;
    }

    /**
     * 提问者id
     */
    @SuppressWarnings("all")
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * 创建时间
     */
    @SuppressWarnings("all")
    public LocalDateTime getCreatetime() {
        return this.createtime;
    }

    /**
     * 状态，0-》未回答，1-》待解决，2-》已解决
     */
    @SuppressWarnings("all")
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 浏览量
     */
    @SuppressWarnings("all")
    public Integer getPageViews() {
        return this.pageViews;
    }

    /**
     * 该问题是否公开，所有学生都可见，0-》否，1-》是
     */
    @SuppressWarnings("all")
    public Integer getPublicStatus() {
        return this.publicStatus;
    }

    @SuppressWarnings("all")
    public LocalDate getModifytime() {
        return this.modifytime;
    }

    @SuppressWarnings("all")
    public Integer getDeleteStatus() {
        return this.deleteStatus;
    }

    @SuppressWarnings("all")
    public String getTagNames() {
        return this.tagNames;
    }

    /**
     * 当前问题的所有标签集合
     * 数据库表中无与之对应的列
     */
    @SuppressWarnings("all")
    public List<Tag> getTags() {
        return this.tags;
    }

    @SuppressWarnings("all")
    public Question setId(final Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 问题的标题
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Question setTitle(final String title) {
        this.title = title;
        return this;
    }

    /**
     * 提问内容
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Question setContent(final String content) {
        this.content = content;
        return this;
    }

    /**
     * 提问者用户名
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Question setUserNickName(final String userNickName) {
        this.userNickName = userNickName;
        return this;
    }

    /**
     * 提问者id
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Question setUserId(final Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 创建时间
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Question setCreatetime(final LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }

    /**
     * 状态，0-》未回答，1-》待解决，2-》已解决
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Question setStatus(final Integer status) {
        this.status = status;
        return this;
    }

    /**
     * 浏览量
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Question setPageViews(final Integer pageViews) {
        this.pageViews = pageViews;
        return this;
    }

    /**
     * 该问题是否公开，所有学生都可见，0-》否，1-》是
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Question setPublicStatus(final Integer publicStatus) {
        this.publicStatus = publicStatus;
        return this;
    }

    @SuppressWarnings("all")
    public Question setModifytime(final LocalDate modifytime) {
        this.modifytime = modifytime;
        return this;
    }

    @SuppressWarnings("all")
    public Question setDeleteStatus(final Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
        return this;
    }

    @SuppressWarnings("all")
    public Question setTagNames(final String tagNames) {
        this.tagNames = tagNames;
        return this;
    }

    /**
     * 当前问题的所有标签集合
     * 数据库表中无与之对应的列
     * @return {@code this}.
     */
    @SuppressWarnings("all")
    public Question setTags(final List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Question(id=" + this.getId() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", userNickName=" + this.getUserNickName() + ", userId=" + this.getUserId() + ", createtime=" + this.getCreatetime() + ", status=" + this.getStatus() + ", pageViews=" + this.getPageViews() + ", publicStatus=" + this.getPublicStatus() + ", modifytime=" + this.getModifytime() + ", deleteStatus=" + this.getDeleteStatus() + ", tagNames=" + this.getTagNames() + ", tags=" + this.getTags() + ")";
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Question)) return false;
        final Question other = (Question) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$pageViews = this.getPageViews();
        final Object other$pageViews = other.getPageViews();
        if (this$pageViews == null ? other$pageViews != null : !this$pageViews.equals(other$pageViews)) return false;
        final Object this$publicStatus = this.getPublicStatus();
        final Object other$publicStatus = other.getPublicStatus();
        if (this$publicStatus == null ? other$publicStatus != null : !this$publicStatus.equals(other$publicStatus)) return false;
        final Object this$deleteStatus = this.getDeleteStatus();
        final Object other$deleteStatus = other.getDeleteStatus();
        if (this$deleteStatus == null ? other$deleteStatus != null : !this$deleteStatus.equals(other$deleteStatus)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$userNickName = this.getUserNickName();
        final Object other$userNickName = other.getUserNickName();
        if (this$userNickName == null ? other$userNickName != null : !this$userNickName.equals(other$userNickName)) return false;
        final Object this$createtime = this.getCreatetime();
        final Object other$createtime = other.getCreatetime();
        if (this$createtime == null ? other$createtime != null : !this$createtime.equals(other$createtime)) return false;
        final Object this$modifytime = this.getModifytime();
        final Object other$modifytime = other.getModifytime();
        if (this$modifytime == null ? other$modifytime != null : !this$modifytime.equals(other$modifytime)) return false;
        final Object this$tagNames = this.getTagNames();
        final Object other$tagNames = other.getTagNames();
        if (this$tagNames == null ? other$tagNames != null : !this$tagNames.equals(other$tagNames)) return false;
        final Object this$tags = this.getTags();
        final Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Question;
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
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $pageViews = this.getPageViews();
        result = result * PRIME + ($pageViews == null ? 43 : $pageViews.hashCode());
        final Object $publicStatus = this.getPublicStatus();
        result = result * PRIME + ($publicStatus == null ? 43 : $publicStatus.hashCode());
        final Object $deleteStatus = this.getDeleteStatus();
        result = result * PRIME + ($deleteStatus == null ? 43 : $deleteStatus.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $userNickName = this.getUserNickName();
        result = result * PRIME + ($userNickName == null ? 43 : $userNickName.hashCode());
        final Object $createtime = this.getCreatetime();
        result = result * PRIME + ($createtime == null ? 43 : $createtime.hashCode());
        final Object $modifytime = this.getModifytime();
        result = result * PRIME + ($modifytime == null ? 43 : $modifytime.hashCode());
        final Object $tagNames = this.getTagNames();
        result = result * PRIME + ($tagNames == null ? 43 : $tagNames.hashCode());
        final Object $tags = this.getTags();
        result = result * PRIME + ($tags == null ? 43 : $tags.hashCode());
        return result;
    }
    //</editor-fold>
}
