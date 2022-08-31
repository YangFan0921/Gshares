package com.review.shares.portal.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class HotQuestionVo {

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

}
