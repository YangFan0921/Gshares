package com.review.shares.portal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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
     * 用户昵称
     */
    @TableField("user_nick_name")
    private String userNickName;
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


}
