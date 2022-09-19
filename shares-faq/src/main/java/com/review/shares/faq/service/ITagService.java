package com.review.shares.faq.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.review.shares.commons.model.Tag;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
public interface ITagService extends IService<Tag> {

    //全查所有标签返回List
    List<Tag> getTags();

    //全查所有标签返回Map
    Map<String,Tag> getTagMap();


}
