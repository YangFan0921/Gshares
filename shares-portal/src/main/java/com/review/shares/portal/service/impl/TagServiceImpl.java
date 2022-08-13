package com.review.shares.portal.service.impl;

import com.review.shares.portal.model.Tag;
import com.review.shares.portal.mapper.TagMapper;
import com.review.shares.portal.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getTags() {
        if (tags.isEmpty()){
            synchronized (tags) {
                if(tags.isEmpty()) {
                    List<Tag> tags = tagMapper.selectList(null);
                    this.tags.addAll(tags);
                }
            }
        }
        return tags;
    }
}
