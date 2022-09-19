package com.review.shares.faq.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.review.shares.commons.model.Tag;
import com.review.shares.faq.mapper.TagMapper;
import com.review.shares.faq.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    //线程安全的List
    private List<Tag> tags = new CopyOnWriteArrayList<>();

    //线程安全的HashMap
    private Map<String,Tag> tagMap = new ConcurrentHashMap<>();

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getTags() {
        if (tags.isEmpty()){
            synchronized (tags) {
                if(tags.isEmpty()) {
                    List<Tag> tags = tagMapper.selectList(null);
                    this.tags.addAll(tags);
                    //遍历List将tag对象添加进Map
                    for (Tag t : tags){
                        tagMap.put(t.getName(),t);
                    }
                }
            }
        }
        return tags;
    }

    @Override
    public Map<String, Tag> getTagMap() {
        if (tagMap.isEmpty()){
            getTags();
        }
        return tagMap;
    }
}
