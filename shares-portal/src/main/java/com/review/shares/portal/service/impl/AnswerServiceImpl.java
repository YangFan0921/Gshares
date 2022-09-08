package com.review.shares.portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.review.shares.portal.exception.ServiceException;
import com.review.shares.portal.mapper.UserMapper;
import com.review.shares.portal.model.Answer;
import com.review.shares.portal.mapper.AnswerMapper;
import com.review.shares.portal.model.User;
import com.review.shares.portal.service.IAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.review.shares.portal.vo.AnswerVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements IAnswerService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private AnswerMapper answerMapper;

    @Override
    @Transactional
    public Answer saveAnswer(AnswerVo answerVo, String username) {
        User user = userMapper.findUserByUsername(username);
        Answer answer = new Answer()
                .setQuestId(answerVo.getQuestionId())
                .setContent(answerVo.getContent())
                .setUserId(user.getId())
                .setUserNickName(user.getNickname())
                .setLikeCount(0)
                .setAcceptStatus(0)
                .setCreatetime(LocalDateTime.now());
        int num = answerMapper.insert(answer);
        if (num!=1){
            throw new ServiceException("服务器忙！");
        }
        return answer;
    }

    @Override
    public List<Answer> getAnswersByQuestionId(Integer questionId) {
        QueryWrapper<Answer> query = new QueryWrapper<>();
        query.eq("quest_id",questionId);
        List<Answer> answers = answerMapper.selectList(query);
        return answers;
    }
}
