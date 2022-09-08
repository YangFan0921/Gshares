package com.review.shares.portal.vo;

import java.io.Serializable;

public class UserVo implements Serializable {
    private Integer id;
    private String username;
    private String nickname;
    //提问数
    private int questions;
    //收藏数
    private int collections;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public UserVo() {
    }

    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getUsername() {
        return this.username;
    }

    @SuppressWarnings("all")
    public String getNickname() {
        return this.nickname;
    }

    @SuppressWarnings("all")
    public int getQuestions() {
        return this.questions;
    }

    @SuppressWarnings("all")
    public int getCollections() {
        return this.collections;
    }

    @SuppressWarnings("all")
    public UserVo setId(final Integer id) {
        this.id = id;
        return this;
    }

    @SuppressWarnings("all")
    public UserVo setUsername(final String username) {
        this.username = username;
        return this;
    }

    @SuppressWarnings("all")
    public UserVo setNickname(final String nickname) {
        this.nickname = nickname;
        return this;
    }

    @SuppressWarnings("all")
    public UserVo setQuestions(final int questions) {
        this.questions = questions;
        return this;
    }

    @SuppressWarnings("all")
    public UserVo setCollections(final int collections) {
        this.collections = collections;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserVo)) return false;
        final UserVo other = (UserVo) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getQuestions() != other.getQuestions()) return false;
        if (this.getCollections() != other.getCollections()) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof UserVo;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getQuestions();
        result = result * PRIME + this.getCollections();
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "UserVo(id=" + this.getId() + ", username=" + this.getUsername() + ", nickname=" + this.getNickname() + ", questions=" + this.getQuestions() + ", collections=" + this.getCollections() + ")";
    }
    //</editor-fold>
}
