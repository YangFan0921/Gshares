package com.review.shares.portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.review.shares.portal.exception.ServiceException;
import com.review.shares.portal.mapper.UserMapper;
import com.review.shares.portal.model.Question;
import com.review.shares.portal.mapper.QuestionMapper;
import com.review.shares.portal.model.Tag;
import com.review.shares.portal.model.User;
import com.review.shares.portal.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.review.shares.portal.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo<Question> getMyQuestion(String username, Integer pageNum, Integer pageSize) {
        //根据用户名查询用户信息
        User user = userMapper.findUserByUsername(username);
        if (user == null){
            throw new ServiceException("用户不存在");
        }
        //根据用户id查询用户的所有问题
        QueryWrapper<Question> query = new QueryWrapper<>();
        //条件： 1.user_id为当前登录用户的id
        query.eq("user_id",user.getId());
        //      2.查询出的问题不能是被删除的
        query.eq("delete_status",0);
        //      3.设置创建时间降序排序
        query.orderByDesc("createtime");
        //分页查询的指令
        PageHelper.startPage(pageNum,pageSize);
        List<Question> list = questionMapper.selectList(query);
        //为每个问题的标签集合赋值
        for (Question question : list){
            List<Tag> tags = tagName2Tags(question.getTagNames());
            question.setTags(tags);
        }
        return new PageInfo<>(list);
    }

    @Autowired
    private ITagService tagService;
    //标签名称字符串转换为List<Tag>
    private List<Tag> tagName2Tags(String tagNames){
        String[] names = tagNames.split(",");
        List<Tag> tags = new ArrayList<>();
        Map<String,Tag> tagMap = tagService.getTagMap();
        //将数组元素对应的tag对象保存至tags集合中
        for (String key : names){
            tags.add(tagMap.get(key));
        }
        return tags;
    }

}
