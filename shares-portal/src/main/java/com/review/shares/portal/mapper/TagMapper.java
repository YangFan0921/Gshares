package com.review.shares.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.review.shares.portal.model.Tag;
import org.springframework.stereotype.Repository;

//BaseMapper是MyBatis Plus提供的父接口
//其中有对<>中指定的实体类的基本增删改查方法
public interface TagMapper extends BaseMapper<Tag> {

}
