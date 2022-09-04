package com.review.shares.portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.review.shares.portal.exception.ServiceException;
import com.review.shares.portal.mapper.*;
import com.review.shares.portal.model.*;
import com.review.shares.portal.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.review.shares.portal.service.ITagService;
import com.review.shares.portal.service.IUserService;
import com.review.shares.portal.vo.HotQuestionVo;
import com.review.shares.portal.vo.QuestionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
@Slf4j
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

    @Autowired
    private QuestionTagMapper questionTagMapper;
    @Autowired
    private UserQuestionMapper userQuestionMapper;
    @Autowired
    private IUserService userService;
    @Override
    @Transactional
    public void saveQuestion(QuestionVo questionVo, String username) {
        //1.根据用户名查询用户信息
        User user = userMapper.findUserByUsername(username);
        //2.根据学生选中的标签构建tag_names列的值
        StringBuilder builder = new StringBuilder();
        for (String tagName : questionVo.getTagNames()){
            builder.append(tagName).append(",");
        }
        String tagNames = builder.deleteCharAt(builder.length()-1).toString();
        //3.实例化Question对象并赋值
        Question question = new Question()
                .setTitle(questionVo.getTitle())
                .setContent(questionVo.getContent())
                .setUserNickName(user.getNickname())
                .setUserId(user.getId())
                .setCreatetime(LocalDateTime.now())
                .setStatus(0)
                .setPageViews(0)
                .setPublicStatus(0)
                .setDeleteStatus(0)
                .setTagNames(tagNames);
        //4.新增Question
        int num = questionMapper.insert(question);
        if (num != 1){
            throw new ServiceException("服务器忙");
        }
        //5.新增Question和tag的关系
        Map<String,Tag> tagMap = tagService.getTagMap();
        for (String tarName : questionVo.getTagNames()){
            Tag t = tagMap.get(tarName);
            QuestionTag questionTag = new QuestionTag()
                    .setQuestionId(question.getId())
                    .setTagId(t.getId());
            num = questionTagMapper.insert(questionTag);
            if (num != 1){
                throw new ServiceException("服务器忙");
            }
            log.debug("新增问题和标签的关系:{}",questionTag);
        }
        //6.新增User(老师)和Question的关系
        Map<String,User> teacherMap = userService.getTeacherMap();
        for (String nickname : questionVo.getTeacherNicknames()){
            User teacher = teacherMap.get(nickname);
            UserQuestion userQuestion = new UserQuestion()
                    .setQuestionId(question.getId())
                    .setUserId(teacher.getId())
                    .setCreatetime(LocalDateTime.now());
            num = userQuestionMapper.insert(userQuestion);
            if (num != 1){
                throw new ServiceException("服务器忙");
            }
            log.debug("新增问题和老师的关系:{}",userQuestion);
        }
    }

    @Override
    public Integer countQuestionByUserId(Integer userId) {
        QueryWrapper<Question> query = new QueryWrapper<>();
        query.eq("user_id",userId);
        query.eq("delete_status",0);
        Integer count = questionMapper.selectCount(query);
        return count;
    }


    @Autowired
    UserCollectMapper userCollectMapper;
    @Override
    public Integer collectQuestionByUserId(Integer userId) {
        QueryWrapper<UserCollect> query = new QueryWrapper<>();
        query.eq("user_id",userId);
        Integer count = userCollectMapper.selectCount(query);
        return count;
    }

    @Override
    public List<HotQuestionVo> getHotQuestionList() {
        List<Question> questions = questionMapper.getHotQuestionList();
        List<HotQuestionVo> hotQuestionVo = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
//            System.out.println("hotQuestionVo的长度:"+hotQuestionVo.size());
            Question q = questions.get(i);
//            System.out.println("q:"+q);
//            HotQuestionVo qv = hotQuestionVo.get(i);
            HotQuestionVo qv = new HotQuestionVo();
            Integer countAnswer = questionMapper.countAnswer(q.getId());
            hotQuestionVo.add(qv);
//            System.out.println("qv:"+qv);
            qv.setId(q.getId());
            qv.setTitle(q.getTitle());
            qv.setStatus(q.getStatus());
            qv.setPageViews(q.getPageViews());
            qv.setCountAnswer(countAnswer);
//            System.out.println("hotQuestionVo:"+hotQuestionVo);
        }
        return hotQuestionVo;
    }

    @Override
    public PageInfo<Question> getTeacherQuestions(String username, Integer pageNum, Integer pageSize) {
        User user = userMapper.findUserByUsername(username);
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questions = questionMapper.findTeacherQuestions(user.getId());
        //为每个问题的标签集合赋值
        for (Question question : questions){
            List<Tag> tags = tagName2Tags(question.getTagNames());
            question.setTags(tags);
        }
        return new PageInfo<>(questions);
    }


}
